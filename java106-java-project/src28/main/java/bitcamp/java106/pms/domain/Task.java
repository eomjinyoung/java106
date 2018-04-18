package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    public static int count = 1;

    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member worker;
    private Team team;
    
    public Task(Team team) {
        this.no = count++;
        this.team = team;
    }
    
    public Task(Team team, String title, Date startDate, Date endDate) {
        this(team);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = READY;
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        // 외부에서 입력 받은 번호가 count 보다 클 때는 count의 값을 증가시켜야 한다.
        if (no >= count) {
            count = no + 1;
        }
        this.no = no;
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

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state
                + ", worker=" + worker + ", team=" + team + "]";
    }
}

//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경
//ver 17 - 사용자 정의 데이터 타입 생성




