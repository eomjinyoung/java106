// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/update")
public class ClassroomUpdateController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomUpdateController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        Classroom classroom = classroomDao.get(no);
        
        if (classroom == null) {
            out.println("유효하지 않은 수업 번호입니다.");
            return;
        } 
        
        Classroom updateClassroom = new Classroom();
        updateClassroom.setNo(no);
        updateClassroom.setTitle(request.getParameter("title"));
        updateClassroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
        updateClassroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
        updateClassroom.setRoom(request.getParameter("room"));
        
        int index = classroomDao.indexOf(no);
        classroomDao.update(index, updateClassroom);
        
        out.println("변경하였습니다.");
    }

}

//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 update() 메서드를 추출하여 클래스로 정의.
