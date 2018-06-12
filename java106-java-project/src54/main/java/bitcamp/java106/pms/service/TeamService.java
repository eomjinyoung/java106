// 서비스 컴포넌트 - 팀관리 업무를 처리할 객체
package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public interface TeamService {
    // 서비스 컴포넌트에서 메서드명을 지을 때는 
    // 업무 용어를 사용하라!
    List<Team> list(int pageNo, int pageSize);
    Team get(String name);
    Team getWithMembers(String name);
    int add(Team team);
    int update(Team team);
    int delete(String name);
    boolean isMember(String teamName, String memberId);
    int addMember(String teamName, String memberId);
    int deleteMember(String teamName, String memberId);
    List<Member> getMembersWithEmail(String teamName);
}

//ver 53 - 인터페이스 추가







