package org.BG.DAO;

import org.BG.DTO.AdvertiseDto;
import org.BG.DTO.AdvertiseV2Dto;
import org.BG.DTO.AdvertiseV3Dto;
import org.BG.Mapper.AdvertiseMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AdvertiseDao {
    @Autowired
    SqlSession sqlSession;

    //광고 두번째 버전
    public ArrayList<AdvertiseV2Dto> getAdvertiseV2(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.getAdvertiseV2();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void uploadAdvertiseV2(AdvertiseV2Dto advertiseV2Dto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.uploadAdvertiseV2(advertiseV2Dto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteAdvertiseV2(AdvertiseV2Dto advertiseV2Dto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.deleteAdvertiseV2(advertiseV2Dto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void appClickAdvertiseV2(AdvertiseV2Dto advertiseV2Dto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.appClickAdvertiseV2(advertiseV2Dto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 광고 첫번째 버번
    public ArrayList<AdvertiseDto> appGetAdvertiseOfChat(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfChat();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfChatRoom(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfChatRoom();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfMainBanner(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfMainBanner();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfMainTop(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfMainTop();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfMainBottom(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfMainBottom();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfChangeEat(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfChangeEat();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfOrderEat(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfOrderEat();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfShop(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfShop();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfDetail(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfDetail();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfReview(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfReview();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> appGetAdvertiseOfCommunity(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.appGetAdvertiseOfCommunity();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean appClickAdvertiseOfReview(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.appClickAdvertiseOfReview(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean appClickAdvertiseOfCommunity(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.appClickAdvertiseOfCommunity(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<AdvertiseDto> countAdvertiseOfReview(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.countAdvertiseOfReview();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<AdvertiseDto> countAdvertiseOfCommunity(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.countAdvertiseOfCommunity();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean uploadAdvertise(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.uploadAdvertise(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean uploadAdvertiseOfReview(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.uploadAdvertiseOfReview(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean uploadAdvertiseOfCommunity(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.uploadAdvertiseOfCommunity(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAdvertise(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.deleteAdvertise(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteAdvertiseFromNo(AdvertiseDto advertiseDto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.deleteAdvertiseFromNo(advertiseDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<AdvertiseV3Dto> getAdvertiseV3(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.getAdvertiseV3();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public void uploadAdvertiseV3(AdvertiseV3Dto advertiseV3Dto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.uploadAdvertiseV3(advertiseV3Dto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteAdvertiseV3(AdvertiseV3Dto advertiseV3Dto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            advertiseMapper.deleteAdvertiseV3(advertiseV3Dto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public AdvertiseV3Dto retrieveAdvertiseV3(AdvertiseV3Dto advertiseV3Dto){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            return advertiseMapper.retrieveAdvertiseV3(advertiseV3Dto);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
