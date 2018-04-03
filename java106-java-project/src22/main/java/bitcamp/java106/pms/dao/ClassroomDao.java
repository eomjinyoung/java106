package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Classroom;

public class ClassroomDao extends AbstractDao<Classroom> {
    
    public int indexOf(Object key) {
        int classroomNo = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getNo() == classroomNo) {
                return i;
            }
        }
        return -1;
    }
}

//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




