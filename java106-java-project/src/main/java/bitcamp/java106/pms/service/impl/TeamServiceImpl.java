// 업무로직 구현체 - 고객사 마다 다른 구현을 할 수 있다.
package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
    
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    
    public TeamServiceImpl(
            TeamDao teamDao, 
            TeamMemberDao teamMemberDao,
            TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public List<Team> list(int pageNo, int pageSize) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        return teamDao.selectList(params);
    }
    
    @Override
    public Team get(String name) {
        return teamDao.selectOne(name);
    }
    
    @Override
    public Team getWithMembers(String name) {
        return teamDao.selectOneWithMembers(name);
    }
    
    @Override
    public int add(Team member) {
        return teamDao.insert(member);
    }
    
    @Override
    public int update(Team member) {
        return teamDao.update(member);
    }
    
    @Override
    public int delete(String name) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", name);
        
        teamMemberDao.delete(params);
        taskDao.deleteByTeam(name);
        return teamDao.delete(name);
    }
}

//ver 53 - 클래스 추가






