package org.BG.Service.proposal;

import org.BG.DAO.ProposalDao;
import org.BG.DTO.ProductDto;
import org.BG.DTO.ProposalDto;
import org.BG.DTO.UserDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProposalServiceImp implements ProposalService {
    @Autowired
    ProposalDao proposalDao;

    @Override
    public ArrayList<ProposalDto> appRetrieveProposalList(UserDto userDto) {
        ArrayList<ProposalDto> proposalDto = new ArrayList<>();
        try{
            proposalDto = proposalDao.appRetrieveProposalList(userDto);
        } catch (Exception e){
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
        try{
            ProposalDto proposalInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerProposal(proposalDto);
            ProductDto myProduct = proposalDao.appRetrieveProposalDetailOfChangeEatVerMyProduct(proposalDto);
            ProductDto yourProduct = proposalDao.appRetrieveProposalDetailOfChangeEatVerYourProduct(proposalDto);
            UserDto myInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerUser(proposalDto);

            //proposalInfo
            jsonProposalInfo.put("key", proposalInfo.getProposal_No());
            jsonProposalInfo.put("state", proposalInfo.getProposal_State());
            jsonProposalInfo.put("way", proposalInfo.getProposal_Ways());
            jsonProposalInfo.put("credit", proposalInfo.getProposal_Credit());
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
        }catch (Exception e){
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
        try{
            ProposalDto proposalInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerProposal(proposalDto);
            ProductDto yourProduct = proposalDao.appRetrieveProposalDetailOfChangeEatVerYourProduct(proposalDto);
            UserDto myInfo = proposalDao.appRetrieveProposalDetailOfChangeEatVerUser(proposalDto);

            //proposalInfo
            jsonProposalInfo.put("key", proposalInfo.getProposal_No());
            jsonProposalInfo.put("state", proposalInfo.getProposal_State());
            jsonProposalInfo.put("way", proposalInfo.getProposal_Ways());
            jsonProposalInfo.put("credit", proposalInfo.getProposal_Credit());
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public String appChangeStateOfProposal(ProposalDto proposalDto){
        try{
            return proposalDao.appChangeStateOfProposal(proposalDto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ProposalDto countProposal() {
        try{
            ProposalDto proposalDto = new ProposalDto();
            proposalDto.setCallCount(proposalDao.countProposalOfCall());
            proposalDto.setChangeCount(proposalDao.countProposalOfChange());
            return proposalDto;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
