package org.BG.Controller;

import com.google.firebase.messaging.FirebaseMessaging;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSON;
import org.BG.DTO.TestDto;
import org.BG.Service.test.TestService;
//import org.BG.util.CGPlacesAPI;
import org.BG.util.ScrapingTaxTypeFromNts;
import org.BG.util.firebase.FirebaseMessagingSnippets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    ScrapingTaxTypeFromNts scrapingTaxTypeFromNts;
    @Autowired
    FirebaseMessagingSnippets firebaseMessagingSnippets;
//    @Autowired
//    CGPlacesAPI cgPlacesAPI;

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
