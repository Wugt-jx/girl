package spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgt on 2017/2/28.
 */
@RestController
public class HelloController {

    @RequestMapping("/say")
    public String say(){
        return "Hello Spring boot!";
    }
}
