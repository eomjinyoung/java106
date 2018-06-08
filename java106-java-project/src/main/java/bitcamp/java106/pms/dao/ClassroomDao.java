package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomDao {
    int delete(int no);
    List<Classroom> selectList(Map<String,Object> params);
    Classroom selectOne(int no);
    int insert(Classroom classroom);
    int update(Classroom classroom);
}

//ver 52 - 페이지 단위로 데이터 가져오기
//ver 50 - 클래스를 인터페이스로 변경
//ver 33 - Mybatis 적용
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




