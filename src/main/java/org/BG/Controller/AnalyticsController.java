package org.BG.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyticsController {
    @GetMapping("/analyticsPage.do")
    public String analyticsPage(){
        return "analytics/analyticsPage";
    }
}
