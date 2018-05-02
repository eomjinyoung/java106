package bitcamp.java106.pms.domain;

import java.io.Serializable;
import java.sql.Date;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String description;
    private int maxQty;
    private Date startDate;
    private Date endDate;

    public String getName() {
        return name;
    }

    public Team setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Team setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public Team setMaxQty(int maxQty) {
        this.maxQty = maxQty;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Team setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Team setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
    
    @Override
    public String toString() {
        return "Team [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
}

//ver 31 - 생성자 제거.
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - 생성자 추가
//ver 17 - toString() 오버라이딩.
//         팀 멤버 관련 메서드를 TeamMemberDao 클래스로 옮긴다.
//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.
//ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.
//          팀 멤버 배열에 멤버 객체를 추가하고 빼는 메서드를 새로 정의한다.
//ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경