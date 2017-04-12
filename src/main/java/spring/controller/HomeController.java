package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.utils.MsgRole;

/**
 * Created by wgt on 2017/3/21.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        MsgRole msg=new MsgRole("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg",msg);
        return "home";
    }
}
