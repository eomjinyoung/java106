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
        
        // InternalResourceViewResolver를 사용하면 
        // view URL을 리턴할 때 다음과 같이 간결해진다.
        return "exam06_4";
    }
    
    @GetMapping(value="m2")  
    public void m2(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        
        // view URL을 리턴하지 않으면 
        // 프론트 컨트롤러는 요청 URL을 기준으로 view URL을 계산한다.
        // 예) http://localhost:8888/java106-spring-webmvc/mvc/exam06_4/m2
        // 프론트 컨트롤러에 전달되는 기본 URL을 제외하면 다음과 같다. 
        //     exam06_4/m2
        // 이 URL을 가지고 InternalResourceViewResolver는 view URL을 계산한다.
        //     prefix + 페이지 컨트롤러 url + suffix
        //     = "/WEB-INF/jsp/" + "exam06_4/m2" + ".jsp"
        //     = "/WEB-INF/jsp/exam06_4/m2.jsp"
        // 
        // 이 방식의 장점은 
        // JSP를 request handler의 URL에 맞추서 만들면 
        // request handler에서 따로 view URL을 리턴할 필요가 없어 편리하다.
    }
}







