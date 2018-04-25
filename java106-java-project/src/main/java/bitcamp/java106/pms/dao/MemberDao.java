package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class MemberDao {

    DataSource dataSource;
    
    public MemberDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
        
    public int delete(String id) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms_member where mid=?");) {
            
            stmt.setString(1, id);
            return stmt.executeUpdate();
        } 
    }
    
    public List<Member> selectList() throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "select mid, email from pms_member");
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Member> arr = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                arr.add(member);
            }
            return arr;
        }
    }

    public int insert(Member member) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms_member(mid,email,pwd) values(?,?,sha2(?,224))");) {
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
        
            return stmt.executeUpdate();
        }
    }

    public int update(Member member) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "update pms_member set email=?, pwd=sha2(?,224) where mid=?");) {
            
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getId());
            return stmt.executeUpdate();
        }
    }

    public Member selectOne(String id) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "select mid,email from pms_member where mid=?");) {
            
            stmt.setString(1, id);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
                
                Member member = new Member();
                member.setId(id);
                member.setEmail(rs.getString("email"));
                return member;
            }
        }  
    }    
}

//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 사용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - MemberController로부터 데이터 관리 기능을 분리하여 MemberDao 생성.






