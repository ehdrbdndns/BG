package org.BG.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PushController {
    @GetMapping(value = "pushPage.do")
    public String pushPage(){
        return "push/pushPage";
    }

    @GetMapping(value = "pushDetailPage.do")
    public String pushDetailPage(){
        return "push/pushDetailPage";
    }

    @GetMapping(value = "pushMakePage.do")
    public String pushMakePage(){
        return "push/pushMakePage";
    }
}
