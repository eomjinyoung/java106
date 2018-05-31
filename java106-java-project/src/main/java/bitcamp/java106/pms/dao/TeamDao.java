package bitcamp.java106.pms.dao;

import java.util.List;

import bitcamp.java106.pms.domain.Team;

public interface TeamDao {
    int delete(String name);
    List<Team> selectList();
    int insert(Team team);
    int update(Team team);
    Team selectOne(String name);
    Team selectOneWithMembers(String name);
}

//ver 50 - 클래스를 인터페이스로 전환
//ver 42 - JSP 적용에 따라 Team 정보를 가져올 때 그 팀의 Member 정보도 함께 가져온다.
//         selectOneWithMembers() 추가
//ver 33 - Mybatis 적용 
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





