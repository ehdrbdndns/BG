package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
public class TestDto {
    String modelTest1;
    String modelTest2;
    ArrayList<Map<String, MultipartFile>> test1;
    ArrayList<MultipartFile> test2;
    MultipartFile test3;
    MultipartFile test4;
    MultipartFile test5;
    MultipartFile test6;
    MultipartFile test7;
    MultipartFile test8;

    /*파일 넘어오는지 테스트*/
    String FileText;
    MultipartFile File1;
    Map<String, MultipartFile> File2;
}
