package bitcamp.java106.pms.web;

import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.service.MemberService;
import bitcamp.java106.pms.service.TeamService;

@Controller
@RequestMapping("/team/member")
public class TeamMemberController {
    
    TeamService teamService;
    MemberService memberService;
    
    public TeamMemberController(
            TeamService teamService,
            MemberService memberService) {
        
        this.teamService = teamService;
        this.memberService = memberService;
    }
    
    @RequestMapping("add")
    public String add(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId,
            Map<String,Object> map) throws Exception {
        
        if (teamService.get(teamName) == null) {
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        }

        if (memberService.get(memberId) == null) {
            map.put("message", "해당 회원이 없습니다!");
            return "team/member/fail";
        }
        
        if (teamService.isMember(teamName, memberId)) {
            map.put("message", "이미 등록된 회원입니다.");
            return "team/member/fail";
        }
        teamService.addMember(teamName, memberId);
        return "redirect:../" + 
                URLEncoder.encode(teamName, "UTF-8");
    }
    
    @RequestMapping("delete")
    public String delete(
            @RequestParam("teamName") String teamName,
            @RequestParam("memberId") String memberId,
            Map<String,Object> map) throws Exception {
         
        int count = teamService.deleteMember(teamName, memberId);
        if (count == 0) {
            map.put("message", "해당 회원이 없습니다!");
            return "team/member/fail";
        }
        return "redirect:../" + 
                URLEncoder.encode(teamName, "UTF-8");
        // 개발자가 요청이나 응답헤더를 직접 작성하여 값을 주고 받으로 한다면,
        // URL 인코딩과 URL 디코딩을 손수 해 줘야 한다.
    }
    
    @RequestMapping("list")
    public void list(
            @RequestParam("name") String teamName,
            Map<String,Object> map) throws Exception {
        map.put("members", teamService.getMembersWithEmail(teamName));
    }
}

//ver 53 - DAO 대신 Service 객체 사용
//ver 52 - InternalResourceViewResolver 적용
//         *.do 대신 /app/* 을 기준으로 URL 변경
//ver 51 - Spring WebMVC 적용
//ver 50 - DAO 변경에 맞춰 메서드 호출 변경
//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - CharacterEncodingFilter 필터 적용.
//         request.setCharacterEncoding("UTF-8") 제거
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamMemberController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
//ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.