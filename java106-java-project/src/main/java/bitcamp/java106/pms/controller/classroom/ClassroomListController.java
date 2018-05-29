package bitcamp.java106.pms.controller.classroom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.PageController;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

@Component("/classroom/list")
public class ClassroomListController implements PageController {
    
    ClassroomDao classroomDao;
    
    public ClassroomListController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public String service(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
     
        List<Classroom> list = classroomDao.selectList();
        request.setAttribute("list", list);
        return "/classroom/list.jsp";
    }
}

//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 list() 메서드를 추출하여 클래스로 정의.

