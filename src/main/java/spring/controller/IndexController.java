package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgt on 2017/3/19.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        System.out.println("i coming !");
        map.put("host","http://www.baidu.com");
        return "index";
    }
}
