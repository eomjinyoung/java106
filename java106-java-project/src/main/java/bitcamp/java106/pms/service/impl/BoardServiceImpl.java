// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
    
    BoardDao boardDao;
    
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public List<Board> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return boardDao.selectList(params);
    }
    
    @Override
    public Board get(int no) {
        return boardDao.selectOne(no);
    }
    
    @Override
    public int add(Board board) {
        return boardDao.insert(board);
    }
    
    @Override
    public int update(Board board) {
        return boardDao.update(board);
    }
    
    @Override
    public int delete(int no) {
        return boardDao.delete(no);
    }
}

//ver 53 - 클래스 추가






