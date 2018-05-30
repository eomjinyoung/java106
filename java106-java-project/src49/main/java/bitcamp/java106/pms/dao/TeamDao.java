package bitcamp.java106.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import bitcamp.java106.pms.domain.Team;

@Component
public class TeamDao {

    SqlSessionFactory sqlSessionFactory;
    
    public TeamDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(String name) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete(
                    "bitcamp.java106.pms.dao.TeamDao.delete", name);
            sqlSession.commit();
            return count;
        } 
    }
    
    public List<Team> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList(
                    "bitcamp.java106.pms.dao.TeamDao.selectList");
        }
    }

    public int insert(Team team) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.insert(
                    "bitcamp.java106.pms.dao.TeamDao.insert", team);
            sqlSession.commit();
            return count;
        }
    }

    public int update(Team team) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.update(
                    "bitcamp.java106.pms.dao.TeamDao.update", team);
            sqlSession.commit();
            return count;
        }
    }

    public Team selectOne(String name) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.TeamDao.selectOne", name);
        }
    }
    
    public Team selectOneWithMembers(String name) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectOne(
                    "bitcamp.java106.pms.dao.TeamDao.selectOneWithMembers", name);
        }
    }
}

//ver 42 - JSP 적용에 따라 Team 정보를 가져올 때 그 팀의 Member 정보도 함께 가져온다.
//         selectOneWithMembers() 추가
//ver 33 - Mybatis 적용 
//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





