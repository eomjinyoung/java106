package bitcamp.java106.pms.dao;

import java.util.ArrayList;
import java.util.Iterator;

import bitcamp.java106.pms.domain.Task;

public class TaskDao extends AbstractDao<Task> {
    
    // 기존의 list() 메서드로는 작업을 처리할 수 없기 때문에 
    // 팀명으로 작업을 목록을 리턴해주는 메서드를 추가한다. 
    // => 오버로딩
    public Iterator<Task> list(String teamName) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : collection) {
            if (task.getTeam().getName().equalsIgnoreCase(teamName)) {
                tasks.add(task);
            }
        }
        return tasks.iterator();
    }
    
    public int indexOf(Object key) {
        int taskNo = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            Task task = collection.get(i);
            if (task.getNo() == taskNo) {
                return i;
            }
        }
        return -1;
    }
}

//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





