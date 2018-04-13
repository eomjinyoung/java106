// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.board;

import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component("board/view")
public class BoardViewController implements Controller {
    Scanner keyScan;
    BoardDao boardDao;
    
    public BoardViewController(Scanner scanner, BoardDao boardDao) {
        this.keyScan = scanner;
        this.boardDao = boardDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[게시물 조회]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        Board board = boardDao.get(Integer.parseInt(option));
        
        if (board == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            System.out.printf("팀명: %s\n", board.getTitle());
            System.out.printf("설명: %s\n", board.getContent());
            System.out.printf("등록일: %s\n", board.getCreatedDate());
        }
    }
}

//ver 26 - BoardController에서 view() 메서드를 추출하여 클래스로 정의.
