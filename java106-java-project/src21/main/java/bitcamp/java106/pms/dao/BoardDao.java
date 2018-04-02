package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Board;

public class BoardDao {
    private LinkedList<Board> collection = new LinkedList<>();
    
    public void insert(Board board) {
        this.collection.add(board);
    }
    
    public Board[] list() {
        Board[] arr = new Board[this.collection.size()];
        for (int i = 0; i < this.collection.size(); i++) 
            arr[i] = this.collection.get(i);
        return arr;
    }
    
    public Board get(int no) {
        int index = this.getBoardIndex(no);
        if (index < 0) 
            return null;
        return collection.get(index);
    }
    
    public void update(Board board) {
        int index = this.getBoardIndex(board.getNo());
        if (index < 0) 
            return;
        collection.set(index, board);
    }
    
    public void delete(int no) {
        int index = this.getBoardIndex(no);
        if (index < 0) 
            return;
        collection.remove(index);
    }
    
    private int getBoardIndex(int no) {
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = collection.get(i);
            if (originBoard.getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}

//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





