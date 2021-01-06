package org.BG.DAO;

import org.BG.DTO.AdvertiseDto;
import org.BG.Mapper.AdvertiseMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AdvertiseDao {
    @Autowired
    SqlSession sqlSession;

    public ArrayList<AdvertiseDto> appGetAdvertise(){
        try{
            AdvertiseMapper advertiseMapper = sqlSession.getMapper(AdvertiseMapper.class);
            ArrayList<AdvertiseDto> advertiseDtos = advertiseMapper.appGetAdvertise();
            return advertiseDtos;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

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
}
