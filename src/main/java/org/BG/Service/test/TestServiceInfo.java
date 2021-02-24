package org.BG.Service.test;

import org.BG.util.firebase.FirebaseStoreDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TestServiceInfo implements TestService {

    @Autowired
    FirebaseStoreDelete firebaseStoreDelete;

    //사업자 등록 번호 유효성 체크
    private final static int[] LOGIC_NUM = {1, 3, 7, 1, 3, 7, 1, 3, 5, 1};

    @Override
    public boolean adminCheckLicenseNumber(String licenseNumber) {
        licenseNumber = licenseNumber.replaceAll("-","");
        boolean result = isValid(licenseNumber);
        System.out.println("유효성 검사 : " + result);
        return result;
    }

    @Override
    public void testDocutment(HttpServletRequest req, int userNo) throws Exception {
        firebaseStoreDelete.deleteFireStore(req, userNo);
    }

    public boolean isValid(String regNum) {

        if (!isNumeric(regNum) || regNum.length() != 10)
            return false;

        int sum = 0;
        int j = -1;
        for (int i = 0; i < 9; i++) {
            j = Character.getNumericValue(regNum.charAt(i));
            sum += j * LOGIC_NUM[i];
        }

        sum += (int) (Character.getNumericValue(regNum.charAt(8)) * 5 / 10);

        int checkNum = (10 - sum % 10) % 10;
        return (checkNum == Character.getNumericValue(regNum.charAt(9)));
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

}
