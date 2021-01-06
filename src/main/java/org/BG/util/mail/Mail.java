package org.BG.util.mail;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class Mail {

    /*javax.mail 라이브러리 필요.*/
    /*(보내는 이의 이메일, 보내는 이의 이메일 비밀번호, 받는 이의 이메일, 이메일 제목, 이메일 내용)*/
    public boolean MailSender(String email, String password, String to, String title, String contents) {
        if (naverMailSend(email, password, to, title, contents)) {
            /*TODO DB Insert or Success Action*/
            return true;
        } else {
            /*TODO Failed Action*/
            return false;
        }
    }

    private boolean naverMailSend(String email, String pswd, String to, String title, String contents) {
        String host = "smtp.naver.com";
        // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
        final String user = email;
        // 패스워드
        final String password = pswd;
        // SMTP 서버 정보를 설정한다.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user)); /*보내는 사람 메일 주소 API상으론 이메일로 로그인을 한 사람이 보낸다.*/
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); /*받는사람 메일 주소 API상으론 서버에 설정된 이메일로 받는다.*/
            // 메일 제목
            message.setSubject(title);
            // 메일 내용
            message.setText(contents);
            // send the message
            Transport.send(message);
            System.out.println("Success Message Send");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
