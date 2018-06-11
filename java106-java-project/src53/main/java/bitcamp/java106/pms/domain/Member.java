package bitcamp.java106.pms.domain;

import java.io.Serializable;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String email;
    private String password;
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
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