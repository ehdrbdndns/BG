package org.BG.util.firebase;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.*;
import org.json.simple.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@Service
public class FirebaseMessagingSnippets {

    //초기화
    public void initFirebase(HttpServletRequest request){
        try{
            FileInputStream refreshToken = new FileInputStream(request.getSession().getServletContext().getRealPath("/")+"resources/firebase/testchatting-628bb-firebase-adminsdk-6g02q-cbb057057a.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .setDatabaseUrl("https://testchatting-628bb-default-rtdb.firebaseio.com")
                    .build();
            //Firebase 처음 호출시에만 initailizing 처리
            if(FirebaseApp.getApps().isEmpty())
                FirebaseApp.initializeApp(options);
        } catch (Exception e){
            System.out.println("notification error: " + e);
            e.printStackTrace();
        }
    }

    public void android_send_FCM(String tokenId, String file_name, HttpServletRequest request){
        System.out.println("notification 전송 파일 이름: " + file_name);
        try{
            initFirebase(request);

            //안드로이드 토큰 입력

            //message 작성
            Message msg = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                    .setTtl(3600*1000) // 1 hour in milliseconds
                    .setPriority(AndroidConfig.Priority.NORMAL)
                    .setNotification(AndroidNotification.builder()
                    .setTitle("SpeechCoach")
                    .setBody("회원님께서 작성하신 피드백에 대한 답변왔습니다.")
                    .setIcon("stock_ticker_update")
                    .setColor("#f45342")
                    .build())
                    .build())
                    .putData("analytics", file_name)
                    .setToken(tokenId)
                    .build();

            //메세지를 FirebaseMessageing에 보내기
            String response = FirebaseMessaging.getInstance().send(msg);

            //결과 출력
            System.out.println("Successfully sent message: " + response);

        } catch (Exception e){
            System.out.println("notification error: " + e);
            e.printStackTrace();
        }
    }

    public void ios_send_FCM(String tokenId, String file_name, HttpServletRequest request){
        try{
            Notification notification = new Notification("SpeechCoach", "회원님께서 작성하신 피드백에 대한 답변왔습니다.");
            initFirebase(request);

            //안드로이드 토큰 입력

            //message 작성
            Message msg = Message.builder()
                    .setNotification(notification)
                    .putData("analytics", file_name)
                    .setToken(tokenId)
                    .build();

            //메세지를 FirebaseMessageing에 보내기
            String response = FirebaseMessaging.getInstance().send(msg);
            //결과 출력
            System.out.println("Successfully sent message: " + response);

            System.out.println("notification 통과");
        } catch (Exception e){
            System.out.println("notification error: " + e);
            e.printStackTrace();
        }
    }
}
