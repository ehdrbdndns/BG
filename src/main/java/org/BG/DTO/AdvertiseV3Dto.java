package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AdvertiseV3Dto {
    private int Ad_No;
    private String Ad_Title;
    private String Ad_MoveLink;
    private String Ad_MainURL;
    private String Ad_SubURL;

    private MultipartFile Ad_MainFile;
    private MultipartFile Ad_SubFile;
}
