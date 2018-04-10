// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

@Component("classroom/update")
public class ClassroomUpdateController implements Controller {
    Scanner keyScan;
    ClassroomDao classroomDao;
    
    public ClassroomUpdateController(Scanner scanner, ClassroomDao classroomDao) {
        this.keyScan = scanner;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 정보 변경]");
        
        System.out.print("변경할 수업 번호? ");
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Classroom classroom = classroomDao.get(Integer.parseInt(str));
        
        if (classroom == null) {
            System.out.println("유효하지 않은 수업 번호입니다.");
            return;
        } 
        
        Classroom updateClassroom = new Classroom();
        updateClassroom.setNo(classroom.getNo());
        
        System.out.printf("수업명(%s)? ", classroom.getTitle());
        str = this.keyScan.nextLine();
        if (str.length() == 0)
            updateClassroom.setTitle(classroom.getTitle());
        else 
            updateClassroom.setTitle(str);
        
        System.out.printf("시작일(%s)? ", classroom.getStartDate());
        str = this.keyScan.nextLine();
        if (str.length() == 0)
            updateClassroom.setStartDate(classroom.getStartDate());
        else 
            updateClassroom.setStartDate(Date.valueOf(str));
        
        System.out.printf("종료일(%s)? ", classroom.getEndDate());
        str = this.keyScan.nextLine();
        if (str.length() == 0)
            updateClassroom.setEndDate(classroom.getEndDate());
        else 
            updateClassroom.setEndDate(Date.valueOf(str));
        
        System.out.printf("교실명(%s)? ", classroom.getRoom());
        str = this.keyScan.nextLine();
        if (str.length() == 0)
            updateClassroom.setRoom(classroom.getRoom());
        else 
            updateClassroom.setRoom(str);
        
        if (Console.confirm("변경하시겠습니까?")) {
            int index = classroomDao.indexOf(classroom.getNo());
            classroomDao.update(index, updateClassroom);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }

}

//ver 26 - ClassroomController에서 update() 메서드를 추출하여 클래스로 정의.
