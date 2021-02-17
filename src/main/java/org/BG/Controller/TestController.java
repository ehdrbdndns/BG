package org.BG.Controller;

import org.BG.DTO.TestDto;
import org.BG.DTO.UserDto;
import org.BG.Service.login.LoginService;
import org.BG.Service.test.TestService;
import org.BG.Service.user.UserService;
import org.BG.util.Pwd.PwdToByte;
import org.BG.util.ScrapingTaxTypeFromNts;
import org.BG.util.firebase.FirebaseMessagingSnippets;
import org.BG.util.geocoder.GpsToAddress;
import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    UserService userService;
    @Autowired
    ScrapingTaxTypeFromNts scrapingTaxTypeFromNts;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;
    @Autowired
    SqlSession sqlSession;
    @Autowired
    LoginService loginService;
//    @Autowired
//    CGPlacesAPI cgPlacesAPI;

    @ResponseBody
    @RequestMapping(value = "countAllStore")
    public String countAllStore(){
        ArrayList<UserDto> userInfoList = userService.getAllUser();
        for(int i = 0; i<userInfoList.size(); i++){
            loginService.addStoreCount(userInfoList.get(i).getUser_Lat(), userInfoList.get(i).getUser_Lng());
        }
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "changePwd")
    public String changePwd() throws NoSuchAlgorithmException{
       UserDto userDto = userService.searchUser(190);
       userService.updateUserPwd(userDto);
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "changeAllPwd")
    public String changeAllPwd() throws NoSuchAlgorithmException {
        ArrayList<UserDto> userInfoList = userService.getAllUser();
        for(int i = 0; i<userInfoList.size(); i++){
            userService.updateUserPwd(userInfoList.get(i));
        }
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "pwdToByte")
    public String pwdToByte(@RequestParam("pwd") String pwd) throws NoSuchAlgorithmException {
        PwdToByte pwdToByte = new PwdToByte();
        return pwdToByte.encryptionSHA256(pwd);
    }

    @ResponseBody
    @RequestMapping(value = "reversGeocode")
    public String reversGeocode(@RequestParam("lat") Float lat, @RequestParam("lng") Float lng) throws Exception {
        System.out.println("lat: " + lat);
        System.out.println("lng: " + lng);
        GpsToAddress gpsToAddress = new GpsToAddress(lat, lng);
        System.out.println("address: " + gpsToAddress.getAddress());
        System.out.println("address length: " + gpsToAddress.getAddress().split("대한민국").length);
        System.out.println("address[0]: " + gpsToAddress.getAddress().split("대한민국")[0]);
        System.out.println("address[1]: " + gpsToAddress.getAddress().split("대한민국")[1]);
        return "true";
    }

    @RequestMapping(value = "adminCheckLicenseNumber.admin")
    public String adminCheckLicenseNumber(@RequestParam("licenseNumber") String licenseNumber) {
        testService.adminCheckLicenseNumber(licenseNumber);

        List<String> listBusinessRegNo = new ArrayList<>();
        listBusinessRegNo.add(licenseNumber);
        listBusinessRegNo.add("1234");

        List<Map<String, String>> listResult = scrapingTaxTypeFromNts.selectTaxTypeFromNts(listBusinessRegNo);
        for (String businessRegNo : listBusinessRegNo) {
            String result = listResult.stream().filter(map -> map.containsKey(businessRegNo)).map(map -> map.get(businessRegNo)).collect(Collectors.joining());
            System.out.println(businessRegNo + " = " + result);
        }

        return "test";
    }

    @GetMapping("/test")
    public String test(){

        return "test";
    }

//    @RequestMapping(value = "adminCheckGoogleMap.admin", method = RequestMethod.POST)
//    public String adminCheckGoogleMap(@RequestParam("lat") String lat, @RequestParam("lon") String lon){
//        String type = "restaurant";
//        String radius = "5000";
//        String language = "ko";
//        ArrayList<String> arrayList = cgPlacesAPI.parsing(lat, lon, radius, type, language);
//        return "index";
//    }

    @ResponseBody
    @RequestMapping(value = "/test1")
    public String test1(@ModelAttribute("test1")TestDto testDto){
        for(int i = 0; i<testDto.getTest1().size(); i++){
            Set key = testDto.getTest1().get(i).keySet();
            Iterator iterator = key.iterator();
            String keyName = (String) iterator.next();
            System.out.println("name: " + keyName);
            System.out.println("file: " + testDto.getTest1().get(i).get(keyName));
        }
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public String test2(@ModelAttribute("test2") TestDto testDto){
        for(int i = 0; i<testDto.getTest2().size(); i++){
            System.out.println("name: " + testDto.getTest2().get(i).getOriginalFilename());
            System.out.println("file: " + testDto.getTest2().get(i));
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/test3")
    public String test3(@RequestParam Map<String, MultipartFile> files){
        Set key = files.keySet();
        Iterator iterator = key.iterator();
        String keyName = (String) iterator.next();
        System.out.println("name: " + keyName);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/fileTest1.do")
    public String fileTest1(@ModelAttribute TestDto testDto){
        try{
            System.out.println("텍스트: " + testDto.getFileText());
            System.out.println("파일 텍스트: " + testDto.getFile1());
            System.out.println("파일 이름: " + testDto.getFile1().getOriginalFilename());
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/fileTest2.do")
    public String fileTest2(@ModelAttribute TestDto testDto){
        try{
            System.out.println("텍스트: " + testDto.getFileText());
            System.out.println("파일 텍스트: " + testDto.getFile2());
            Set key = testDto.getFile2().keySet();
            Iterator iterator = key.iterator();
            String keyName = (String) iterator.next();
            System.out.println("name: " + keyName);
            return "true";
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/testSendNotification.do", method = RequestMethod.GET)
    public boolean testSendNotification(@RequestParam(value = "fcm") String token, HttpServletRequest request){
        try{
            firebaseMessagingSnippets.test_send_FCM(token, "테스트 알람","잘 가나용?", request);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
