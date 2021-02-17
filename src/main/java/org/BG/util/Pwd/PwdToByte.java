package org.BG.util.Pwd;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdToByte {
    /**
     * SHA-256으로 해싱하는 메소드
     *
     * @param msg
     * @return bytes
     * @throws NoSuchAlgorithmException
     */
    public String encryptionSHA256(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        return bytesToHex(md.digest());
    }

    /**
     * 바이트를 헥스값으로 변환한다.
     *
     * @param bytes
     * @return
     */
    public String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
