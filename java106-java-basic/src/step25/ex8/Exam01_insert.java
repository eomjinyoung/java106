// mybatis + spring IoC - 트랜잭션 적용 전
package step25.ex8;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex8/application-context.xml");
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        Board board = new Board();
        board.setNo(131);
        board.setTitle("1111");
        board.setContent("xxxx");
        
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(132);
        board.setTitle("2222");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(133);
        board.setTitle("3333");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        System.out.println("-------------------------------------");
        
        List<Board> list = boardDao.selectList();
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n",
                    b.getNo(), b.getTitle(), b.getRegisteredDate());
        }
    }
}







