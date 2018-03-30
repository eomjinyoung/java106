package bitcamp.java106.pms.dao;

import java.util.LinkedList;

import bitcamp.java106.pms.domain.Team;

public class TeamDao {
    
    private LinkedList<Team> collection = new LinkedList<>();
    
    public void insert(Team team) {
        collection.add(team);
    }
    
    public Team[] list() {
        Team[] arr = new Team[collection.size()];
        for (int i = 0; i < collection.size(); i++) 
            arr[i] = collection.get(i);
        return arr;
    }
    
    public Team get(String name) {
        int i;
        if ((i = this.getTeamIndex(name)) != -1)
            return collection.get(i);
        return null;
    }
    
    public void update(Team team) {
        int i;
        if ((i = this.getTeamIndex(team.getName())) != -1)
            collection.set(i, team);
    }
    
    public void delete(String name) {
        int i;
        if ((i = this.getTeamIndex(name)) != -1) 
            collection.remove(i);
    }
    
    private int getTeamIndex(String name) {
        for (int i = 0; i < collection.size(); i++) {
            if (name.toLowerCase().equals(
                   collection.get(i).getName().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

}

//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





