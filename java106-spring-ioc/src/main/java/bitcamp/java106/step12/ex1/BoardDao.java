package bitcamp.java106.step12.ex1;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.step12.Board;

@Component
public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public BoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<Board> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList("BoardMapper.selectList");
        }
    }

    public int insert(Board board) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("BoardMapper.insert", board);
            sqlSession.commit();
            return count;
        }
    }
   
}





