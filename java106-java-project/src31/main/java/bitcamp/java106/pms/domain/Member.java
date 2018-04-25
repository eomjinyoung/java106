package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String email;
    private String password;
    
    public String getId() {
        return id;
    }
    public Member setId(String id) {
        this.id = id;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public Member setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getPassword() {
        return password;
    }
    public Member setPassword(String password) {
        this.password = password;
        return this;
    }
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", email=" + email + ", password=" + password + "]";
    }
    
    
}

//ver 31 - 생성자 제거
//ver 27 - java.io.Serializable 인터페이스 구현
//ver 24 - 생성자 추가
//ver 17 - toString() 재정의.
//ver 16 - 캡슐화 적용. 겟터, 셋터 추가.