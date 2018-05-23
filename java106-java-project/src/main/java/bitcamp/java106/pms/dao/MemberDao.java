package bitcamp.java106.pms.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao {

    SqlSessionFactory sqlSessionFactory;
    
    public MemberDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
        
    public int delete(String id) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.MemberDao.delete", id);
            sqlSession.commit();
            return count;
        }
    }
    
    public List<Member> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.MemberDao.selectList");
        }
    }

    public int insert(Member member) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.insert(
                    "bitcamp.java106.pms.dao.MemberDao.insert", member);
            sqlSession.commit();
            return count;
        }
    }

    public int update(Member member) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.update(
                    "bitcamp.java106.pms.dao.MemberDao.update", member);
            sqlSession.commit();
            return count;
        }
    }

    public Member selectOne(String id) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.MemberDao.selectOne", id);
        }   
    }
    
    public Member selectOneWithPassword(String id, String password) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            HashMap<String,String> params = new HashMap<>();
            params.put("id", id);
            params.put("password", password);
            
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.MemberDao.selectOneWithPassword", params);
        }   
    }
}

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






