package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;

    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private String room;
    
    @Override
    public String toString() {
        return "Classroom [no=" + no + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
                + ", room=" + room + "]";
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
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
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    
    
}

//ver 31 - 생성자 제거 및 count 변수 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - setNo() 변경 