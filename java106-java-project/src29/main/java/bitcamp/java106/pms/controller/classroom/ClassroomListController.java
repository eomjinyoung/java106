// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/list")
public class ClassroomListController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomListController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        Iterator<Classroom> iterator = classroomDao.list();
        while (iterator.hasNext()) {
            Classroom classroom = iterator.next();
            out.printf("%d, %s, %s ~ %s, %s\n",
                classroom.getNo(), classroom.getTitle(), 
                classroom.getStartDate(), classroom.getEndDate(),
                classroom.getRoom());
        }
    }
}

//ver 28 - 네트워크 버전으로 변경
//ver 26 - ClassroomController에서 list() 메서드를 추출하여 클래스로 정의.

