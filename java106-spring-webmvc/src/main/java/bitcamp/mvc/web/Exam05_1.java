// 요청 핸들러의 파라미터 - 파라미터로 받을 수 있는 객체
package bitcamp.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam05_1") 
public class Exam05_1 {
    
    // 프론트 컨트롤러로부터 ServletRequest와 ServletResponse 객체를 받을 수 있다.
    // => 그냥 해당 타입의 파라미터를 선언만 하면 된다.
    @GetMapping(value="m1")  
    @ResponseBody  
    public String m1(
            ServletRequest request,
            ServletResponse response) {
        return "Exam05_1.m1()";
    }
    
    @GetMapping(value="m2")  
    @ResponseBody  
    public String m2(
            HttpServletRequest request,
            HttpServletResponse response) {
        return "Exam05_1.m2()";
    }
    
    @GetMapping(value="m3")  
    @ResponseBody  
    public String m3(HttpSession session) {
        return "Exam05_1.m3()";
    }
    
    // 주의!
    // => ServletContext는 요청 핸들러의 파라미터로 받을 수 없다.
    // => 대신에 의존 객체로 주입 받아야 한다.
    /*
    @GetMapping(value="m4")  
    @ResponseBody  
    public String m4(ServletContext servletContext) {
        return "Exam05_1.m4()";
    }
    */
    @Autowired ServletContext servletContext;
    
    
}







