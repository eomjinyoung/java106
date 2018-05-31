// Spring과 Mybatis 연동 : 단순 연동
package bitcamp.java106.step12.ex1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;
import bitcamp.java106.step12.Board;

public class Exam01 {

    public static void main(String[] args) {
        
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step12/ex1/application-context.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        List<Board> list = boardDao.selectList();
        
        for (Board board : list) {
            System.out.printf("%d, %s, %s\n", 
                    board.getNo(),
                    board.getTitle(),
                    board.getRegisteredDate());
        }
    }

}





