package bitcamp.java106.pms.controller.board;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component("board/add")
public class BoardAddController implements Controller {
    Scanner keyScan;
    BoardDao boardDao;
    
    public BoardAddController(Scanner scanner, BoardDao boardDao) {
        this.keyScan = scanner;
        this.boardDao = boardDao;
    }
    
    public void service(String menu, String option) {
        // 이 컨트롤러는 오직 게시물 입력에 대해서만 작업을 수행한다.
        System.out.println("[게시물 입력]");
        Board board = new Board();

        System.out.print("제목? ");
        board.setTitle(this.keyScan.nextLine());

        System.out.print("내용? ");
        board.setContent(this.keyScan.nextLine());

        System.out.print("등록일? ");
        board.setCreatedDate(Date.valueOf(this.keyScan.nextLine()));

        boardDao.insert(board);
    }

}

//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
