package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;

public class ClassroomController {
    Scanner keyScan;

    ClassroomDao classroomDao = new ClassroomDao();
    
    public ClassroomController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("classroom/add")) {
            this.onAdd();
        } else if (menu.equals("classroom/list")) {
            this.onList();
        } else if (menu.equals("classroom/update")) {
            //this.onClassroomUpdate(option);
        } else if (menu.equals("classroom/delete")) {
            //this.onClassroomDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    void onAdd() {
        System.out.println("[수업 등록]");
        Classroom classroom = new Classroom();

        System.out.print("제목? ");
        classroom.setTitle(this.keyScan.nextLine());

        System.out.print("시작일? ");
        classroom.setStartDate(Date.valueOf(this.keyScan.nextLine()));

        System.out.print("종료일? ");
        classroom.setEndDate(Date.valueOf(this.keyScan.nextLine()));

        System.out.print("교실명? ");
        classroom.setRoom(this.keyScan.nextLine());
        
        classroomDao.insert(classroom);
    }

    void onList() {
        System.out.println("[수업 목록]");
        Classroom[] list = classroomDao.list();
        for (Classroom classroom : list) {
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                classroom.getNo(), classroom.getTitle(), 
                classroom.getStartDate(), classroom.getEndDate(),
                classroom.getRoom());
        }
    }

    /*
    void onClassroomView(String option) {
        System.out.println("[게시물 조회]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Classroom classroom = classroomDao.get(Integer.parseInt(option));
        
        if (classroom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            System.out.printf("팀명: %s\n", classroom.getTitle());
            System.out.printf("설명: %s\n", classroom.getContent());
            System.out.printf("등록일: %s\n", classroom.getCreatedDate());
        }
    }

    void onClassroomUpdate(String option) {
        System.out.println("[게시물 변경]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Classroom classroom = classroomDao.get(Integer.parseInt(option));
        
        if (classroom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            Classroom updateClassroom = new Classroom();
            updateClassroom.setNo(classroom.getNo());
            System.out.printf("제목(%s)? ", classroom.getTitle());
            updateClassroom.setTitle(this.keyScan.nextLine());
            System.out.printf("설명(%s)? ", classroom.getContent());
            updateClassroom.setContent(this.keyScan.nextLine());
            updateClassroom.setCreatedDate(classroom.getCreatedDate());
            classroomDao.update(updateClassroom);
            System.out.println("변경하였습니다.");
        }
    }

    void onClassroomDelete(String option) {
        System.out.println("[게시물 삭제]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return; 
        }
        
        int i = Integer.parseInt(option);
        Classroom classroom = classroomDao.get(i);
        
        if (classroom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                classroomDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }
*/
}

//ver 20 - 클래스 추가
