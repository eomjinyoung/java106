package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

    MemberDao memberDao;
    
    public MemberController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping("/add")
    public String add(Member member) throws Exception {
          
        memberDao.insert(member);
        return "redirect:list.do";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") String id) throws Exception {
        
        int count = memberDao.delete(id);
        if (count == 0) {
            throw new Exception("해당 회원이 없습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/list")
    public String list(Map<String, Object> map) throws Exception {
        
        List<Member> list = memberDao.selectList();
        map.put("list", list);
        return "/member/list.jsp";
    }
    
    @RequestMapping("/update")
    public String update(Member member) throws Exception {
        
        int count = memberDao.update(member);
        if (count == 0) {
            throw new Exception("해당 회원이 존재하지 않습니다.");
        }
        return "redirect:list.do";
    }
    
    @RequestMapping("/view")
    public String view(
            @RequestParam("id") String id,
            Map<String,Object> map) throws Exception {

        Member member = memberDao.selectOne(id);
        if (member == null) {
            throw new Exception("유효하지 않은 멤버 아이디입니다.");
        }
        map.put("member", member);
        return "/member/view.jsp";
    }
}

//ver 51 - Spring WebMVC 적용
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
//ver 26 - MemberController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - MemberDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 MemberDao를 사용한다.
//         onMemberList()에서 배열의 각 항목에 대해 null 값을 검사하는 부분을 제거한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - MemberDao를 생성자에서 주입 받도록 변경.
// ver 14 - MemberDao를 사용하여 회원 데이터를 관리한다.
