// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    
    TaskDao taskDao;
    
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    
    @Override
    public List<Task> list(String teamName, int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        params.put("teamName", teamName);
        
        return taskDao.selectList(params);
    }
    
    @Override
    public Task get(int no) {
        return taskDao.selectOne(no);
    }
    
    @Override
    public int add(Task task) {
        return taskDao.insert(task);
    }
    
    @Override
    public int update(Task task) {
        return taskDao.update(task);
    }
    
    @Override
    public int delete(int no) {
        return taskDao.delete(no);
    }
}

//ver 53 - 클래스 추가






