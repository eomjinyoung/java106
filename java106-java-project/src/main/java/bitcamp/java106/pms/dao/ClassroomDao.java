package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Classroom;

@Component
public class ClassroomDao {
    public int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms_classroom where crno=?");) {
            
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        } 
    }
    
    public List<Classroom> selectList() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UCT&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select crno,titl,sdt,edt,room from pms_classroom");
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Classroom> arr = new ArrayList<>();
            while (rs.next()) {
                Classroom classroom = new Classroom();
                classroom.setNo(rs.getInt("crno"));
                classroom.setTitle(rs.getString("titl"));
                classroom.setStartDate(rs.getDate("sdt"));
                classroom.setEndDate(rs.getDate("edt"));
                classroom.setRoom(rs.getString("room"));
                arr.add(classroom);
            }
            return arr;
        }
    }

    public int insert(Classroom classroom) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms_classroom(titl,sdt,edt,room) values(?,?,?,?)");) {
            
            stmt.setString(1, classroom.getTitle());
            stmt.setDate(2, classroom.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, classroom.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(4, classroom.getRoom());
        
            return stmt.executeUpdate();
        }
    }

    public int update(Classroom classroom) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms_classroom set titl=?, sdt=?, edt=?, room=? where crno=?");) {
            
            stmt.setString(1, classroom.getTitle());
            stmt.setDate(2, classroom.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, classroom.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setString(4, classroom.getRoom());
            stmt.setInt(5, classroom.getNo());
            return stmt.executeUpdate();
        }
    }

    public Classroom selectOne(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select crno,titl,sdt,edt,room from pms_classroom where crno=?");) {
            
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
                
                Classroom classroom = new Classroom();
                classroom.setNo(rs.getInt("crno"));
                classroom.setTitle(rs.getString("titl"));
                classroom.setStartDate(rs.getDate("sdt"));
                classroom.setEndDate(rs.getDate("edt"));
                classroom.setRoom(rs.getString("room"));
                return classroom;
            }
        }  
    }
}

//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




