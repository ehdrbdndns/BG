package org.BG.Service.community;

import org.BG.DAO.CommunityDao;
import org.BG.DAO.HomeDao;
import org.BG.DAO.ReplyDao;
import org.BG.DAO.UserDao;
import org.BG.DTO.CommunityDto;
import org.BG.DTO.ReplyDto;
import org.BG.DTO.UserDto;
import org.BG.util.Aws_Cdn.Aws_Cdn_Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class CommunityServiceImp implements CommunityService {
    @Autowired
    CommunityDao communityDao;
    @Autowired
    Aws_Cdn_Service aws_cdn_service;
    @Autowired
    ReplyDao replyDao;
    @Autowired
    UserDao userDao;
    @Autowired
    HomeDao homeDao;

    @Override
    public JSONArray appRetrieveCommunityListOfMy(UserDto userDto) {
        try {
            JSONArray result = new JSONArray();

            UserDto userName = userDao.appRetrieveUserInfo(userDto);
            result.add(userName.getUser_Name());

            JSONParser jsonParser = new JSONParser();
            ArrayList<CommunityDto> communityDtos = communityDao.appRetrieveCommunityListOfMy(userDto);
            for (int i = 0; i < communityDtos.size(); i++) {
                JSONObject community = new JSONObject();
                community.put("key", communityDtos.get(i).getCommunity_No());
                community.put("img", (JSONArray) jsonParser.parse(communityDtos.get(i).getCommunity_Img()));
                community.put("title", communityDtos.get(i).getCommunity_Title());
                community.put("desc", communityDtos.get(i).getCommunity_Contents());
                result.add(community);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appMakeCommunityOfMy(CommunityDto communityDto) {
        try {
            String jsonArrayPath = aws_cdn_service.FileArrayUpload("user/" + communityDto.getUser_No() + "/community/communityImg/", communityDto.getCommunity_Img_File());
            communityDto.setCommunity_Img(jsonArrayPath);
            communityDto.setCommunity_RegDate(getToday());
            return communityDao.appMakeCommunityOfMy(communityDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject appRetrieveCommunityOfMy(CommunityDto communityDto) {
        JSONObject result = new JSONObject();
        JSONArray jsonArrayImg = new JSONArray();
        JSONParser jsonParser = new JSONParser();
        try {

            CommunityDto community = communityDao.appRetrieveCommunityOfMy(communityDto);
            result.put("title", community.getCommunity_Title());
            result.put("desc", community.getCommunity_Contents());
            jsonArrayImg = (JSONArray) jsonParser.parse(community.getCommunity_Img());
            result.put("imgs", jsonArrayImg);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appDeleteCommunityOfMy(CommunityDto communityDto) {
        JSONParser jsonParser = new JSONParser();
        try {
            CommunityDto community = communityDao.appRetrieveCommunityOfMy(communityDto);
            JSONArray jsonArray = (JSONArray) jsonParser.parse(community.getCommunity_Img());
            for (int i = 0; i < jsonArray.size(); i++) {
                aws_cdn_service.FileDelete(jsonArray.get(i).toString());
            }
            return communityDao.appDeleteCommunityOfMy(communityDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appModifyCommunityOfMy(CommunityDto communityDto) {
        JSONParser jsonParser = new JSONParser();
        JSONArray basicCommunity = new JSONArray();
        JSONArray newCommunity = new JSONArray();
        try {
            CommunityDto community = communityDao.appRetrieveCommunityOfMy(communityDto);
            //기존 이미지
            basicCommunity = (JSONArray) jsonParser.parse(community.getCommunity_Img());

            if (communityDto.getCommunity_Img_File() != null) {
                for (int i = 0; i < communityDto.getCommunity_Img_File().size(); i++) {
                    if (communityDto.getCommunity_Img_File().get(i) != null) {
                        //이미지가 수정이 되었을 경우
                        if (i <= basicCommunity.size() - 1) {
                            //수정된 img
                            aws_cdn_service.FileDelete("user/" + communityDto.getUser_No() + "/community/communityImg/" + basicCommunity.get(i));
                        }
                        String imgPath = aws_cdn_service.FileUpload("user/" + communityDto.getUser_No() + "/community/communityImg/", communityDto.getCommunity_Img_File().get(i));
                        newCommunity.add(imgPath);
                    } else {
                        //이미지가 수정이 안 되었을 경우
                        System.out.println("null Community_img_FileList_File: " + i);
                        newCommunity.add(basicCommunity.get(i));
                    }
                }
                communityDto.setCommunity_Img(newCommunity.toJSONString());
            } else {
                System.out.println("null Community_Img_FileList");
                System.out.println(basicCommunity.toJSONString());
                communityDto.setCommunity_Img(basicCommunity.toJSONString());
            }

            String check = communityDao.appModifyCommunityOfMy(communityDto);
            System.out.println("return 값: " + check);
            return check;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONArray appRetrieveCommunityListOfMain(CommunityDto communityDto) {
        JSONArray result = new JSONArray();
        JSONParser jsonParser = new JSONParser();
        try {
            communityDto.setLastIndex(communityDto.getFirstIndex() + 10);

            String search = "";
            search = communityDto.getSearch();
            if (search.equals("")) {
                search = "%%";
            } else {
                search = "%" + search + "%";
            }
            communityDto.setSearch(search);

            ArrayList<CommunityDto> communityDtos = new ArrayList<>();
            if (communityDto.getCategory().equals("new")) {
                communityDto.setCommunity_RegDate(getToday());
                communityDtos = communityDao.appRetrieveCommunityListOfMainNew(communityDto);
            } else if (communityDto.getCategory().equals("best")) {
                communityDtos = communityDao.appRetrieveCommunityListOfMainBest(communityDto);
            } else if (communityDto.getCategory().equals("view")) {
                communityDtos = communityDao.appRetrieveCommunityListOfMainView(communityDto);
            } else {
                System.out.println("apRetrieveCommunityListOfMain err category: " + communityDto.getCategory());
                return null;
            }

            result.add(communityDto.getLastIndex());
            for (int i = 0; i < communityDtos.size(); i++) {
                JSONObject item = new JSONObject();
                item.put("key", communityDtos.get(i).getCommunity_No());
                item.put("like", communityDtos.get(i).getCommunity_Likes());
                item.put("img", (JSONArray) jsonParser.parse(communityDtos.get(i).getCommunity_Img()));
                item.put("title", communityDtos.get(i).getCommunity_Title());
                item.put("content", communityDtos.get(i).getCommunity_Contents());
                item.put("user", communityDtos.get(i).getUser_ComNm());
                item.put("user_key", communityDtos.get(i).getUser_No());
                result.add(item);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONArray appRetrieveCommunityDetailOfMain(CommunityDto communityDto) {
        JSONArray result = new JSONArray();
        try {
            //조회수 증가
            communityDao.increaseCommunityView(communityDto);

            CommunityDto communityInfo = communityDao.appRetrieveCommunityOfMy(communityDto);
            result.add(communityInfo.getCommunity_Likes());

            ReplyDto replyDto = new ReplyDto();
            replyDto.setCommunity_No(communityDto.getCommunity_No());
            ArrayList<ReplyDto> replyDtos = replyDao.appRetrieveReply(replyDto);

            if (replyDtos.size() != 0) {
                result.add(1);
                for (int i = 0; i < replyDtos.size(); i++) {
                    ReplyDto reply_reply = replyDao.appRetrieveReplyOfReply(replyDtos.get(i));
                    JSONObject item = new JSONObject();
                    item.put("reply_no", replyDtos.get(i).getReply_No());
                    item.put("content", replyDtos.get(i).getReply_Comments());
                    item.put("regDate", replyDtos.get(i).getReply_RegDate());
                    item.put("userName", replyDtos.get(i).getUser_Name());
                    item.put("userImg", replyDtos.get(i).getStore_Img());
                    if (reply_reply != null) {
                        item.put("reply_userName", reply_reply.getRR_UserName());
                        item.put("reply_userImg", reply_reply.getRR_StoreImg());
                        item.put("reply_content", reply_reply.getRR_Comments());
                        item.put("reply_regDate", reply_reply.getRR_RegDate());
                    } else {
                        item.put("reply_userName", null);
                        item.put("reply_userImg", null);
                        item.put("reply_content", null);
                        item.put("reply_regDate", null);
                    }
                    result.add(item);
                }
            } else {
                result.add(0);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<CommunityDto> getCommunityList() {
        try {
            ArrayList<CommunityDto> communityDtos = communityDao.getCommunityList();
            for (int i = 0; i < communityDtos.size(); i++) {
                communityDtos.get(i).setReply_Count(communityDao.countCommunityReply(communityDtos.get(i)));
            }
            return communityDtos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CommunityDto getCommunityInfo(CommunityDto communityDto){
        try{
            CommunityDto communityInfo = communityDao.getCommunityInfo(communityDto);
            communityInfo.setReply_Count(communityDao.countCommunityReply(communityDto));
            communityInfo.changeStringToJSON(communityInfo.getCommunity_Img());
            return communityInfo;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getToday() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
}
