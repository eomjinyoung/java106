package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;

public class BoardDao {
    Board[] boards = new Board[1000];
    int boardIndex = 0;
    
    public void insert(Board board) {
        board.setNo(boardIndex);
        this.boards[this.boardIndex++] = board;
    }
    
    public Board[] list() {
        Board[] arr = new Board[boardIndex];
        for (int i = 0; i < boardIndex; i++) 
            arr[i] = boards[i];
        return arr;
    }
    
    public Board get(int i) {
        if (i < 0 || i >= boardIndex)
            return null;
        return boards[i];
    }
    
    public void update(Board board) {
        boards[board.getNo()] = board;
    }
    
    public void delete(int i) {
        boards[i] = null;
    }
}

// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





