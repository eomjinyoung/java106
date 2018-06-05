// view resolver 다루기 - 기본 뷰 리졸버를 InternalResourceViewResolver로 교체한다.
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/exam06_4") 
public class Exam06_4 {
    
    @GetMapping(value="m1")  
    public String m1(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        
        return "/WEB-INF/jsp/exam06_4.jsp";
    }
}







