package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class TaskDao {

    DataSource dataSource;
    
    public TaskDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
            
    public int delete(int no) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms_task where tano=?");) {
            
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        } 
    }
    
    public List<Task> selectList(String teamName) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "select tano,titl,sdt,edt,stat,mid from pms_task where tnm=?");) {
            
            stmt.setString(1, teamName);    
            try (ResultSet rs = stmt.executeQuery()) {
                ArrayList<Task> arr = new ArrayList<>();
                while (rs.next()) {
                    Task task = new Task();
                    task.setNo(rs.getInt("tano"));
                    task.setTitle(rs.getString("titl"));
                    task.setStartDate(rs.getDate("sdt"));
                    task.setEndDate(rs.getDate("edt"));
                    task.setState(rs.getInt("stat"));
                    task.setWorker(new Member().setId(rs.getString("mid")));
                    arr.add(task);
                }
                return arr;
            }
        }
    }

    public int insert(Task task) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms_task(titl,sdt,edt,mid,tnm) values(?,?,?,?,?)");) {
            
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, task.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(4, task.getWorker().getId());
            stmt.setString(5, task.getTeam().getName());
            return stmt.executeUpdate();
        }
    }

    public int update(Task task) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "update pms_task set titl=?,sdt=?,edt=?,mid=?,tnm=? where tano=?");) {
            
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, task.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(4, task.getWorker().getId());
            stmt.setString(5, task.getTeam().getName());
            stmt.setInt(6, task.getNo());
            return stmt.executeUpdate();
        }
    }

    public Task selectOne(int no) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "select titl,sdt,edt,stat,mid,tnm from pms_task where tano=?");) {
            
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
                
                Task task = new Task();
                task.setNo(no);
                task.setTitle(rs.getString("titl"));
                task.setStartDate(rs.getDate("sdt"));
                task.setEndDate(rs.getDate("edt"));
                task.setState(rs.getInt("stat"));
                task.setWorker(new Member().setId(rs.getString("mid")));
                task.setTeam(new Team().setName(rs.getString("tnm")));
                return task;
            }
        }  
    }

    public int updateState(int no, int state) throws Exception {
        try (
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "update pms_task set stat=? where tano=?");) {
            
            stmt.setInt(1, state);
            stmt.setInt(2, no);
            return stmt.executeUpdate();
        }
    }
}

//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





