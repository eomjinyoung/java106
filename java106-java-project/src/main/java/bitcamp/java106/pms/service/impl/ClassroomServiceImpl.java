// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    
    ClassroomDao classroomDao;
    
    public ClassroomServiceImpl(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    @Override
    public List<Classroom> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return classroomDao.selectList(params);
    }
    
    @Override
    public Classroom get(int no) {
        return classroomDao.selectOne(no);
    }
    
    @Override
    public int add(Classroom classroom) {
        return classroomDao.insert(classroom);
    }
    
    @Override
    public int update(Classroom classroom) {
        return classroomDao.update(classroom);
    }
    
    @Override
    public int delete(int no) {
        return classroomDao.delete(no);
    }
}

//ver 53 - 클래스 추가






