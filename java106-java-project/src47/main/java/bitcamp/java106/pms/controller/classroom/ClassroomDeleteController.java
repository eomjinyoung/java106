package bitcamp.java106.pms.controller.classroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/classroom/delete")
public class ClassroomDeleteController {
    
    ClassroomDao classroomDao;
    
    public ClassroomDeleteController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @RequestMapping
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
     
        int no = Integer.parseInt(request.getParameter("no"));
        int count = classroomDao.delete(no);
        if (count == 0) {
            throw new Exception("<p>해당 강의가 없습니다.</p>");
        }
        return "redirect:list.do";
    }
    
}

//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 delete() 메서드를 추출하여 클래스로 정의.
