package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.ArrayList;

public class BoardDao {
    ArrayList collection = new ArrayList();
    
    public void insert(Board board) {
        this.collection.add(board);
    }
    
    public Board[] list() {
        Board[] arr = new Board[this.collection.size()];
        for (int i = 0; i < this.collection.size(); i++) 
            arr[i] = (Board) this.collection.get(i);
        return arr;
    }
    
    public Board get(int no) {
        for (int i = 0; i < collection.size(); i++) {
            Board board = (Board)collection.get(i);
            if (board.getNo() == no)
                return board;
        }
        return null;
    }
    
    public void update(Board board) {
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = (Board)collection.get(i);
            if (originBoard.getNo() == board.getNo()) {
                collection.set(i, board);
            }
        }
    }
    
    public void delete(int no) {
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = (Board)collection.get(i);
            if (originBoard.getNo() == no) {
                collection.remove(i);
            }
        }
    }
}

//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





