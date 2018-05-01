// DB 커넥션 객체를 관리하는 역할
// => 빌려주는 역할을 수행한다.
package bitcamp.java106.pms.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public class DefaultDataSource implements DataSource {
    String driver;
    String jdbcUrl;
    String user;
    String password;
    
    ArrayList<Connection> conPool = new ArrayList<>();
    
    // 생성자를 호출할 때 지정된 경로의 프로퍼티 파일을 읽어 로딩한다. 
    // JDBC 관련 프로퍼티 값을 읽는다.
    public DefaultDataSource(String propFilePath) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(propFilePath));
        this.driver = props.getProperty("jdbc.driver");
        this.jdbcUrl = props.getProperty("jdbc.url");
        this.user = props.getProperty("jdbc.username");
        this.password = props.getProperty("jdbc.password");
        
        // JDBC 드라이버 로딩 및 DriverManager에 등록
        Class.forName(driver); 
        // Driver 클래스가 로딩될 때 스스로 객체를 자동 생성하여 DriverManager에 등록한다.
    }
    
    
    public DefaultDataSource(String driver, String jdbcUrl, 
            String user, String password) throws Exception {
        this.driver = driver;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        
        // JDBC 드라이버 로딩 및 DriverManager에 등록
        Class.forName(driver); 
        // Driver 클래스가 로딩될 때 스스로 객체를 자동 생성하여 DriverManager에 등록한다. 
    }
    
    public Connection getConnection() throws Exception {
        if (conPool.size() == 0) {
            // 저장된 커넥션 객체가 없다면, 새로 생성한다.
            System.out.println("새 연결 객체를 만든다.");
            return new ConnectionProxy(
                    this,
                    DriverManager.getConnection(jdbcUrl, user, password));
        }
        
        // 기존 커넥션을 꺼낸다. 
        while (conPool.size() > 0) {
            Connection con = conPool.remove(0);
            
            if (!con.isClosed() && // 보관소에서 꺼낸 커넥션 객체가 닫혀있지 않고,
                    con.isValid(1)) { // 그 연결이 유효하다면,
                // 유효한 커네션이 있다면 리턴한다.
                return con;
            }
        }
        
        // 없으면 새로 만든다.
        System.out.println("새 연결 객체를 만든다.");
        return new ConnectionProxy(
                this,
                DriverManager.getConnection(jdbcUrl, user, password));
    }
    
    public void returnConnection(Connection con) {
        conPool.add(con);
    }
}




