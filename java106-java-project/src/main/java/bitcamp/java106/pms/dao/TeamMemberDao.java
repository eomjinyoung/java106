package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Member;

public interface TeamMemberDao {
    int insert(Map<String,Object> params);
    int delete(Map<String,Object> params);
    List<String> selectList(String teamName);
    List<Member> selectListWithEmail(String teamName);
    boolean isExist(Map<String,Object> params);
}

//ver 50 - 클래스를 인터페이스로 전환
//ver 37 - selectListWithEmail() 추가 
//ver 33 - Mybatis 적용
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 17 - 클래스 추가









