package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// 모든 페이지 컨트롤러에 대해 조언을 수행하는 클래스 정의
// => 다음 애노테이션을 붙이면 프론트 컨트롤러는 페이지 컨트롤러를 실행하지 전에 
//    먼저 이 클래스를 살펴볼 것이다.
@ControllerAdvice
public class Exam05_5_GlobalControllerAdvice {
    @InitBinder 
    public void initBinder(WebDataBinder binder) {
        System.out.println("Exam05_5_GlobalControllerAdvice.initBinder()");
        
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(Date.valueOf(text));
                    }
                });
    }
}
