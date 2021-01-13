package org.BG.Service.proposal;

import net.sf.json.JSON;
import org.BG.DAO.*;
import org.BG.DTO.ProductDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.ShopinDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class ProposalServiceImp implements ProposalService {
    @Autowired
    ProposalDao proposalDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    SISDao sisDao;
    @Autowired
    StoreDao storeDao;
    @Autowired
    UserDao userDao;

    @Override
    public ArrayList<ProposalDto> appRetrieveProposalList(UserDto userDto) {
        ArrayList<ProposalDto> proposalDto = new ArrayList<>();
        try {
            proposalDto = proposalDao.appRetrieveProposalList(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proposalDto;
    }

    @Override
    public JSONObject appRetrieveProposalDetailOfChangeEat(ProposalDto proposalDto) {
        JSONObject result = new JSONObject();
        JSONObject jsonProposalInfo = new JSONObject();
        JSONObject jsonMyProduct = new JSONObject();
        JSONObject jsonYourProduct = new JSONObject();
        try {
            ProposalDto proposalInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerProposal(proposalDto);
            ProductDto myProduct = proposalDao.appRetrieveProposalDetailOfChangeEatVerMyProduct(proposalDto);
            ProductDto yourProduct = proposalDao.appRetrieveProposalDetailOfChangeEatVerYourProduct(proposalDto);
            UserDto myInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerUser(proposalDto);

            //proposalInfo
            jsonProposalInfo.put("key", proposalInfo.getProposal_No());
            jsonProposalInfo.put("state", proposalInfo.getProposal_State());
            jsonProposalInfo.put("way", proposalInfo.getProposal_Ways());
            jsonProposalInfo.put("credit", proposalInfo.getProposal_Credit());
            jsonProposalInfo.put("chatRoom", proposalInfo.getProposal_Room());
            //채팅방 로직이 끝난 후 추후 진행
            //jsonProposalInfo.put("chatRoom", proposalInfo.getProposal_ChatRoom);

            //요청자 정보
            jsonMyProduct.put("myAddress", myInfo.getUser_Addr());
            jsonMyProduct.put("myPhone", myInfo.getUser_Phone());
            jsonMyProduct.put("myStore", myInfo.getStore_No());
            jsonMyProduct.put("productImg", myProduct.getProduct_Img());
            jsonMyProduct.put("productName", myProduct.getProduct_Name());
            jsonMyProduct.put("productComponent", myProduct.getProduct_Compo());
            jsonMyProduct.put("productPrice", myProduct.getProduct_Price());
            jsonMyProduct.put("productSales", myProduct.getProduct_Sales());

            //수신자 정보
            jsonYourProduct.put("productImg", yourProduct.getProduct_Img());
            jsonYourProduct.put("productName", yourProduct.getProduct_Name());
            jsonYourProduct.put("productComponent", yourProduct.getProduct_Compo());
            jsonYourProduct.put("productPrice", yourProduct.getProduct_Price());
            jsonYourProduct.put("productSales", yourProduct.getProduct_Sales());

            result.put("proposalInfo", jsonProposalInfo);
            //other는 요청자 혹은 송신자
            result.put("other", jsonMyProduct);
            //my는 수신자
            result.put("my", jsonYourProduct);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JSONObject appRetrieveProposalDetailOfCallEat(ProposalDto proposalDto) {
        JSONObject result = new JSONObject();
        JSONObject jsonProposalInfo = new JSONObject();
        JSONObject jsonMyProduct = new JSONObject();
        JSONObject jsonYourProduct = new JSONObject();
        try {
            ProposalDto proposalInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerProposal(proposalDto);
            ProductDto yourProduct = proposalDao.appRetrieveProposalDetailOfChangeEatVerYourProduct(proposalDto);
            UserDto myInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerUser(proposalDto);

            //proposalInfo
            jsonProposalInfo.put("key", proposalInfo.getProposal_No());
            jsonProposalInfo.put("state", proposalInfo.getProposal_State());
            jsonProposalInfo.put("way", proposalInfo.getProposal_Ways());
            jsonProposalInfo.put("credit", proposalInfo.getProposal_Credit());
            jsonProposalInfo.put("chatRoom", proposalInfo.getProposal_Room());
            //채팅방 로직이 끝난 후 추후 진행
            //jsonProposalInfo.put("chatRoom", proposalInfo.getProposal_ChatRoom);

            //요청자 정보
            jsonMyProduct.put("myAddress", myInfo.getUser_Addr());
            jsonMyProduct.put("myPhone", myInfo.getUser_Phone());
            jsonMyProduct.put("myStore", myInfo.getStore_No());

            //수신자 정보
            jsonYourProduct.put("productImg", yourProduct.getProduct_Img());
            jsonYourProduct.put("productName", yourProduct.getProduct_Name());
            jsonYourProduct.put("productComponent", yourProduct.getProduct_Compo());
            jsonYourProduct.put("productPrice", yourProduct.getProduct_Price());
            jsonYourProduct.put("productSales", yourProduct.getProduct_Sales());

            result.put("proposalInfo", jsonProposalInfo);
            //other는 요청자 혹은 송신자
            result.put("other", jsonMyProduct);
            //my는 수신자
            result.put("my", jsonYourProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String appChangeStateOfProposal(ProposalDto proposalDto) {
        try {
            return proposalDao.appChangeStateOfProposal(proposalDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ProposalDto countProposal() {
        try {
            ProposalDto proposalDto = new ProposalDto();
            proposalDto.setCallCount(proposalDao.countProposalOfCall());
            proposalDto.setChangeCount(proposalDao.countProposalOfChange());
            return proposalDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JSONObject appRetrieveProductFromUserNo(ProposalDto proposalDto) {
        JSONObject result = new JSONObject();
        try {
            UserDto userDto = new UserDto();
            userDto.setUser_No(proposalDto.getMy_No());
            //송신자 정보
            UserDto userInfo = userDao.appRetrieveUserInfo(userDto);
            JSONObject userInfoJson = new JSONObject();
            userInfoJson.put("userName", userInfo.getUser_Name());
            userInfoJson.put("storeName", userInfo.getUser_ComNm());
            userInfoJson.put("img", userInfo.getStore_Img());
            userInfoJson.put("phone", userInfo.getUser_Phone());
            userInfoJson.put("address", userInfo.getUser_Addr());

            result.put("myInfo", userInfoJson);

            //송신자 바꿔먹어 상품
            ArrayList<ProductDto> myProductListOfStore = productDao.appRetrieveChangeProductFromUser_NoToStore_No(proposalDto.getMy_No());
            JSONArray myProductJSON = new JSONArray();
            //스토어 상품
            for (int i = 0; i < myProductListOfStore.size(); i++) {
                JSONObject object = new JSONObject();
                object.put("key", myProductListOfStore.get(i).getProduct_No());
                object.put("name", myProductListOfStore.get(i).getProduct_Name());
                object.put("compo", myProductListOfStore.get(i).getProduct_Compo());
                object.put("price", myProductListOfStore.get(i).getProduct_Price());
                object.put("sales", myProductListOfStore.get(i).getProduct_Sales());
                object.put("img", myProductListOfStore.get(i).getProduct_Img());
                object.put("test", "스토어");

                myProductJSON.add(object);
            }

            //송신자 샵인샵 상품
            ArrayList<ShopinDto> myShopinNoList = new ArrayList<>();
            //샵인샵의 부모인 상점이 존재하는지 체크
            if (myProductListOfStore.size() != 0) {
                int store_No = myProductListOfStore.get(0).getStore_No();

                //샵인 샵 리스트 뽑아오기
                myShopinNoList = sisDao.appRetrieveSISNoFromStore_No(store_No);
                for(int i = 0; i<myShopinNoList.size(); i++){
                    //샵인 샵 바꿔먹어 상품
                    ArrayList<ProductDto> myProductListOfSIS = productDao.appRetrieveChangeProductFromShopin_No(myShopinNoList.get(i).getShopin_No());
                    for(int j = 0; j<myProductListOfSIS.size(); j++){
                        JSONObject object = new JSONObject();
                        object.put("key", myProductListOfSIS.get(j).getProduct_No());
                        object.put("name", myProductListOfSIS.get(j).getProduct_Name());
                        object.put("compo", myProductListOfSIS.get(j).getProduct_Compo());
                        object.put("price", myProductListOfSIS.get(j).getProduct_Price());
                        object.put("sales", myProductListOfSIS.get(j).getProduct_Sales());
                        object.put("img", myProductListOfSIS.get(j).getProduct_Img());
                        object.put("test", "샵인샵");

                        myProductJSON.add(object);
                    }
                }
            }
            result.put("myChange", myProductJSON);

            //수신자 바꿔먹어 상품
            ArrayList<ProductDto> yourChangeListOfStore = productDao.appRetrieveChangeProductFromUser_NoToStore_No(proposalDto.getYour_No());
            JSONArray yourChangeJSON = new JSONArray();
            for (int i = 0; i < yourChangeListOfStore.size(); i++) {
                JSONObject object = new JSONObject();
                object.put("key", yourChangeListOfStore.get(i).getProduct_No());
                object.put("name", yourChangeListOfStore.get(i).getProduct_Name());
                object.put("compo", yourChangeListOfStore.get(i).getProduct_Compo());
                object.put("price", yourChangeListOfStore.get(i).getProduct_Price());
                object.put("sales", yourChangeListOfStore.get(i).getProduct_Sales());
                object.put("img", yourChangeListOfStore.get(i).getProduct_Img());

                yourChangeJSON.add(object);
            }

            //수신자 샵인샵 상품
            ArrayList<ShopinDto> yourShopinNoList = new ArrayList<>();

            //샵인샵의 부모인 상점이 존재하는지 체크
            if (yourChangeListOfStore.size() != 0) {
                //샵인 샵 리스트 뽑아오기
                int store_No = yourChangeListOfStore.get(0).getStore_No();
                yourShopinNoList = sisDao.appRetrieveSISNoFromStore_No(store_No);

                for(int i = 0; i<yourShopinNoList.size(); i++){
                    //샵인 샵 바꿔먹어 상품
                    ArrayList<ProductDto> yourProductListOfSIS = productDao.appRetrieveChangeProductFromShopin_No(yourShopinNoList.get(i).getShopin_No());
                    for(int j = 0; j<yourProductListOfSIS.size(); j++){
                        JSONObject object = new JSONObject();
                        object.put("key", yourProductListOfSIS.get(j).getProduct_No());
                        object.put("name", yourProductListOfSIS.get(j).getProduct_Name());
                        object.put("compo", yourProductListOfSIS.get(j).getProduct_Compo());
                        object.put("price", yourProductListOfSIS.get(j).getProduct_Price());
                        object.put("sales", yourProductListOfSIS.get(j).getProduct_Sales());
                        object.put("img", yourProductListOfSIS.get(j).getProduct_Img());

                        yourChangeJSON.add(object);
                    }
                }
            }

            result.put("yourChange", yourChangeJSON);

            //수진자 시켜먹어 상품
            ArrayList<ProductDto> yourCallListOfStore = productDao.appRetrieveCallProductFromUser_NoToStore_No(proposalDto.getYour_No());
            JSONArray yourCallJSON = new JSONArray();
            for (int i = 0; i < yourCallListOfStore.size(); i++) {
                JSONObject object = new JSONObject();
                object.put("key", yourCallListOfStore.get(i).getProduct_No());
                object.put("name", yourCallListOfStore.get(i).getProduct_Name());
                object.put("compo", yourCallListOfStore.get(i).getProduct_Compo());
                object.put("price", yourCallListOfStore.get(i).getProduct_Price());
                object.put("sales", yourCallListOfStore.get(i).getProduct_Sales());
                object.put("img", yourCallListOfStore.get(i).getProduct_Img());

                yourCallJSON.add(object);
            }

            //샵인샵의 부모인 상점이 존재하는지 체크
            if (yourCallListOfStore.size() != 0) {
                //샵인 샵 리스트 뽑아오기
                int store_No = yourChangeListOfStore.get(0).getStore_No();
                yourShopinNoList = sisDao.appRetrieveSISNoFromStore_No(store_No);

                for(int i = 0; i<yourShopinNoList.size(); i++){

                    //샵인 샵 바꿔먹어 상품
                    ArrayList<ProductDto> yourProductListOfSIS = productDao.appRetrieveCallProductFromShopin_No(yourShopinNoList.get(i).getShopin_No());
                    for(int j = 0; j<yourProductListOfSIS.size(); j++){
                        JSONObject object = new JSONObject();
                        object.put("key", yourProductListOfSIS.get(j).getProduct_No());
                        object.put("name", yourProductListOfSIS.get(j).getProduct_Name());
                        object.put("compo", yourProductListOfSIS.get(j).getProduct_Compo());
                        object.put("price", yourProductListOfSIS.get(j).getProduct_Price());
                        object.put("sales", yourProductListOfSIS.get(j).getProduct_Sales());
                        object.put("img", yourProductListOfSIS.get(j).getProduct_Img());

                        yourCallJSON.add(object);
                    }
                }
            }

            result.put("yourCall", yourCallJSON);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String appRegisterProposal(ProposalDto proposalDto) {
        try{
            proposalDto.setProposal_RegDate(getToday());
            Integer store_no = storeDao.appRetrieveStoreNo(proposalDto.getMy_No());
            proposalDto.setStore_No(store_no);
            return proposalDao.appRegisterProposal(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getToday(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(cal.getTime());
    }
}
