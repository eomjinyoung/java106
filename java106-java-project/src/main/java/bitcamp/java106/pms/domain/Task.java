package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member worker;
    private Team team;
    
    public Task() {}
    
    public Task(Team team, String title, Date startDate, Date endDate) {
        this.team = team;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = READY;
    }
    
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public Member getWorker() {
        return worker;
    }
    public void setWorker(Member worker) {
        this.worker = worker;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
}

//ver 17 - 사용자 정의 데이터 타입 생성