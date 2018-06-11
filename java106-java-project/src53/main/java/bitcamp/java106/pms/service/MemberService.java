// 서비스 컴포넌트 - 회원관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Member;

public interface MemberService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는 
    // 업무 용어를 사용하라!
    List<Member> list(int pageNo, int pageSize);
    Member get(String id);
    boolean isExist(String id, String password);
    int add(Member member);
    int update(Member member);
    int delete(String id);
}

//ver 53 - 인터페이스 추가







