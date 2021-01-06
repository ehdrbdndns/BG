package org.BG.DTO;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Getter
@Setter
public class CommunityDto {
    private Integer Community_No;
    private String Community_Title;
    private String Community_Contents;
    private String Community_Img;
    private ArrayList<MultipartFile> Community_Img_File;
    private Integer Community_Likes;
    private String Community_RegDate;
    private int Community_View;

    private int FirstIndex;
    private int LastIndex;

    private Integer User_No;
    private String User_ComNm;
    private String User_Name;

    private String Category;
    private String Search;

    private int Reply_Count;

    private JSONArray Community_Img_Array;

    public void changeStringToJSON(String json) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        Community_Img_Array = (JSONArray) jsonParser.parse(json);
    }

    public Object getCommunity_Img_Array() {
        return Community_Img_Array;
    }
}
