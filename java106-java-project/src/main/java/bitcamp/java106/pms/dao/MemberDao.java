package bitcamp.java106.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Member;

public interface MemberDao {
    int delete(String id);
    List<Member> selectList(Map<String,Object> params);
    int insert(Member member);
    int update(Member member);
    Member selectOne(String id);
    Member selectOneWithPassword(Map<String,Object> params);
}

//ver 52 - 페이지 단위로 데이터 가져오기
//ver 50 - 클래스를 인터페이스로 변경
//ver 41 - 로그인을 위한 selectOneWithPassword(id, password) 메서드 추가
//ver 33 - Mybatis 적용
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 사용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - MemberController로부터 데이터 관리 기능을 분리하여 MemberDao 생성.






