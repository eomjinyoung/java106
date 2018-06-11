// 서비스 컴포넌트 - 수업관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는 
    // 업무 용어를 사용하라!
    List<Classroom> list(int pageNo, int pageSize);
    Classroom get(int no);
    int add(Classroom classroom);
    int update(Classroom classroom);
    int delete(int no);
}

//ver 53 - 인터페이스 추가







