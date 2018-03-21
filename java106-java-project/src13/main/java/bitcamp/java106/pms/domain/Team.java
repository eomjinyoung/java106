package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Team {
    public String name;
    public String description;
    public int maxQty;
    public Date startDate;
    public Date endDate;
}

// ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경