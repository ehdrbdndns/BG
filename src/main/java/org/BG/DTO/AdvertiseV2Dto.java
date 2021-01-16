package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class AdvertiseV2Dto {
    private int Ad_No;
    private String Ad_Title;
    private String Ad_MoveLink;
    private String Ad_URL;
    private int Ad_ClickCount;
    private String Ad_Type;
    private String Ad_Desc;

    private MultipartFile Ad_File;
}
