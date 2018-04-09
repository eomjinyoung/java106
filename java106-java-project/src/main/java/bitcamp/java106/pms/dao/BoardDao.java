package bitcamp.java106.pms.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;

@Component
public class BoardDao extends AbstractDao<Board> {
    
    public BoardDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/board.csv"));
        while (true) {
            // 저장된 데이터를 한 줄 읽는다.
            // 한 줄에 한 개의 게시물 데이터가 있다.
            // 데이터 형식은 다음과 같다.
            // "번호,제목,내용,등록일"
            //
            try {
                String[] arr = in.nextLine().split(",");
                Board board = new Board();
                board.setNo(Integer.parseInt(arr[0]));
                board.setTitle(arr[1]);
                board.setContent(arr[2]);
                board.setCreatedDate(Date.valueOf(arr[3]));
                this.insert(board);
            } catch (Exception e) { // 데이터를 모두 읽었거나 파일 형식에 문제가 있다면,
                //e.printStackTrace();
                break; // 반복문을 나간다.
            }
        }
        in.close();
    }
    
    public void save() throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("data/board.csv"));
        
        Iterator<Board> boards = this.list();
        
        // List에 보관된 데이터를 board.csv 파일에 저장한다.
        // 기존에 저장된 데이터를 덮어쓴다. 즉 처음부터 다시 저장한다.
        while (boards.hasNext()) {
            Board board = boards.next();
            out.printf("%d,%s,%s,%s\n", board.getNo(), board.getTitle(),
                    board.getContent(), board.getCreatedDate());
        }
        out.close();
    }
    
    public int indexOf(Object key) {
        int no = (Integer) key; // Integer ==> int : auto-unboxing
        for (int i = 0; i < collection.size(); i++) {
            Board originBoard = collection.get(i);
            if (originBoard.getNo() == no) {
                return i;
            }
        }
        return -1;
    }
}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 이용하여 인스턴스(의 주소) 목록을 다룬다. 
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardController로부터 데이터 관리 기능을 분리하여 BoardDao 생성.





