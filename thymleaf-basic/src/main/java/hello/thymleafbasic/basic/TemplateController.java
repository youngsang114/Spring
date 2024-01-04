package hello.thymleafbasic.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
    @GetMapping("/templates/template/fragment")
    public String template() {
        return "template/fragment/fragmentMain";
    }

    @GetMapping("/templates/layout")
    public String layout(){
        return "template/layout/layoutMain";
    }
    @GetMapping("/templates/layoutExtend")
    public String layoutExtend(){
        return "template/layoutExtend/layoutExtendMain";
    }
}