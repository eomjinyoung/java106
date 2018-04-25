package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member worker;
    private Team team;
    
    public int getNo() {
        return no;
    }
    public Task setNo(int no) {
        this.no = no;
        return this;
    }
    public int getState() {
        return state;
    }
    public Task setState(int state) {
        this.state = state;
        return this;
    }
    public Member getWorker() {
        return worker;
    }
    public Task setWorker(Member worker) {
        this.worker = worker;
        return this;
    }
    public Team getTeam() {
        return team;
    }
    public Task setTeam(Team team) {
        this.team = team;
        return this;
    }
    public String getTitle() {
        return title;
    }
    public Task setTitle(String title) {
        this.title = title;
        return this;
    }
    public Date getStartDate() {
        return startDate;
    }
    public Task setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }
    public Date getEndDate() {
        return endDate;
    }
    public Task setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state
                + ", worker=" + worker + ", team=" + team + "]";
    }
}

//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 17 - 사용자 정의 데이터 타입 생성




