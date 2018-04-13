package bitcamp.java106.pms.controller.board;

import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component("board/list")
public class BoardListController implements Controller {
    Scanner keyScan;
    BoardDao boardDao;
    
    public BoardListController(Scanner scanner, BoardDao boardDao) {
        this.keyScan = scanner;
        this.boardDao = boardDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[게시물 목록]");
        Iterator<Board> iterator = boardDao.list();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%d, %s, %s\n",
                board.getNo(), board.getTitle(), board.getCreatedDate());
        }
    }
}

//ver 26 - BoardController에서 list() 메서드를 추출하여 클래스로 정의. 
