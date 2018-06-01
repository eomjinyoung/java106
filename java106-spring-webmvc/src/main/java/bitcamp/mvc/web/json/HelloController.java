package bitcamp.mvc.web.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("web.json.HelloController")
public class HelloController {
    
    @RequestMapping("/hello2")
    public String hello() {
        return "/hello2.jsp";
    }
}
