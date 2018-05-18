package bitcamp.java106.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        memberDao = InitServlet.getApplicationContext().getBean(MemberDao.class);
    }

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>멤버 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>멤버 목록</h1>");
        
        try {
            List<Member> list = memberDao.selectList();
            
            out.println("<p><a href='form.html'>새회원</a></p>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("    <th>아이디</th><th>이메일</th>");
            out.println("</tr>");
            
            for (Member member : list) {
                out.println("<tr>");
                out.printf("    <td><a href='view?id=%s'>%s</a></td><td>%s</td>\n",
                    member.getId(),
                    member.getId(),
                    member.getEmail());
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e);
            request.setAttribute("title", "회원 목록조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 39 - forward 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - MemberController에서 list() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - MemberDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 MemberDao를 사용한다.
//         onMemberList()에서 배열의 각 항목에 대해 null 값을 검사하는 부분을 제거한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - MemberDao를 생성자에서 주입 받도록 변경.
// ver 14 - MemberDao를 사용하여 회원 데이터를 관리한다.
