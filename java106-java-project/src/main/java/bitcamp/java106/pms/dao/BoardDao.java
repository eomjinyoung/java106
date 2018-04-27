package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;
    DataSource dataSource;
    
    public BoardDao(DataSource dataSource, SqlSessionFactory sqlSessionFactory) {
        this.dataSource = dataSource;
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms_board where bno=?");) {
            
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        } 
    }
    
    public List<Board> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.BoardDao.selectList");
        }
    }

    public int insert(Board board) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.insert(
                    "bitcamp.java106.pms.dao.BoardDao.insert", board);
            sqlSession.commit();
            return count;
        }
    }

    public int update(Board board) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "update pms_board set titl=?, cont=?, cdt=now() where bno=?");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }

    public Board selectOne(int no) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,cont,cdt from pms_board where bno=?");) {
            
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
                
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setCreatedDate(rs.getDate("cdt"));
                return board;
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
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





