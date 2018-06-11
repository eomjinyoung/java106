package step25.ex8;

import java.util.List;

public interface BoardDao {
    List<Board> selectList();
    int insert(Board board);
}









