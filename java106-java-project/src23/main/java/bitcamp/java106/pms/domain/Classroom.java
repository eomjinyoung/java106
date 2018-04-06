package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Classroom {
    private static int count;
    
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private String room;
    
    public Classroom() {
        this.no = ++count;
    }
    
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
