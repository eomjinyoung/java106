// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

@Component("classroom/list")
public class ClassroomListController implements Controller {
    Scanner keyScan;
    ClassroomDao classroomDao;
    
    public ClassroomListController(Scanner scanner, ClassroomDao classroomDao) {
        this.keyScan = scanner;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 목록]");
        Iterator<Classroom> iterator = classroomDao.list();
        while (iterator.hasNext()) {
            Classroom classroom = iterator.next();
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                classroom.getNo(), classroom.getTitle(), 
                classroom.getStartDate(), classroom.getEndDate(),
                classroom.getRoom());
        }
    }
}

//ver 26 - ClassroomController에서 list() 메서드를 추출하여 클래스로 정의.

