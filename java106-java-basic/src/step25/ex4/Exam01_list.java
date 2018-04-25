// 게시물 관리 - JDBC 코드를 별도의 클래스로 캡슐화시킴. DAO 적용.
package step25.ex4;

import java.util.List;

public class Exam01_list {

    public static void main(String[] args) throws Exception {
        DataSource dataSource = new DataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        BoardDao boardDao = new BoardDao(dataSource);
        
        try {
            List<Board> list = boardDao.list();
            
            for (Board board : list) {
                System.out.printf("%d,%s,%s\n", 
                    board.getNo(),  
                    board.getTitle(),
                    board.getRegisteredDate()); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







