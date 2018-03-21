// 스태틱 멤버(변수 및 메서드)를 인스턴스 멤버로 변경한다. 
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController {
    public Scanner keyScan;

    Board[] boards = new Board[1000];
    int boardIndex = 0;

    public void service(String menu, String option) {
        if (menu.equals("board/add")) {
            this.onBoardAdd();
        } else if (menu.equals("board/list")) {
            this.onBoardList();
        } else if (menu.equals("board/view")) {
            this.onBoardView(option);
        } else if (menu.equals("board/update")) {
            this.onBoardUpdate(option);
        } else if (menu.equals("board/delete")) {
            this.onBoardDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onBoardAdd() {
        System.out.println("[게시물 입력]");
        Board board = new Board();

        System.out.print("제목? ");
        board.title = this.keyScan.nextLine();

        System.out.print("내용? ");
        board.content = this.keyScan.nextLine();

        System.out.print("등록일? ");
        board.createdDate = this.keyScan.nextLine();

        this.boards[this.boardIndex++] = board;
    }

    void onBoardList() {
        System.out.println("[게시물 목록]");
        for (int i = 0; i < this.boardIndex; i++) {
            if (this.boards[i] == null) continue;
            System.out.printf("%d, %s, %s\n",
                i, this.boards[i].title, this.boards[i].createdDate);
        }
    }

    void onBoardView(String option) {
        System.out.println("[게시물 조회]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        int i = Integer.parseInt(option);
        
        if (i < 0 || i >= this.boardIndex) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            Board board = this.boards[i];
            System.out.printf("팀명: %s\n", board.title);
            System.out.printf("설명: %s\n", board.content);
            System.out.printf("등록일: %s\n", board.createdDate);
        }
    }

    void onBoardUpdate(String option) {
        System.out.println("[게시물 변경]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        int i = Integer.parseInt(option);
        
        if (i < 0 || i >= this.boardIndex) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            Board board = this.boards[i];
            Board updateBoard = new Board();
            System.out.printf("제목(%s)? ", board.title);
            updateBoard.title = this.keyScan.nextLine();
            System.out.printf("설명(%s)? ", board.content);
            updateBoard.content = this.keyScan.nextLine();
            updateBoard.createdDate = board.createdDate;
            this.boards[i] = updateBoard;
            System.out.println("변경하였습니다.");
        }
    }

    void onBoardDelete(String option) {
        System.out.println("[게시물 삭제]");
        if (option == null) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return; 
        }
        
        int i = Integer.parseInt(option);
        
        if (i < 0 || i >= this.boardIndex) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                this.boards[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}