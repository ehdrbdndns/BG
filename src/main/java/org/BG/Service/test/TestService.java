package org.BG.Service.test;

import javax.servlet.http.HttpServletRequest;

public interface TestService {
    boolean adminCheckLicenseNumber(String licenseNumber);
    void testDocutment(HttpServletRequest req, int userNo) throws Exception;
}
