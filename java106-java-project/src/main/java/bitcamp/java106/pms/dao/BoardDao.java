package bitcamp.java106.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public BoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.BoardDao.delete", no);
            sqlSession.commit();
            return count;
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
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.update(
                    "bitcamp.java106.pms.dao.BoardDao.update", board);
            sqlSession.commit();
            return count;
        }
    }

    public Board selectOne(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.BoardDao.selectOne", no);
        }  
    }
}

//ver 33 - Mybatis 적용 
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





