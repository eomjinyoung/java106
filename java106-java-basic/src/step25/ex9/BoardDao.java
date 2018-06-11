package step25.ex9;

import java.util.List;

public interface BoardDao {
    List<Board> selectList();
    int insert(Board board);
}









