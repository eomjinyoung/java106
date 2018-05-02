package bitcamp.java106.pms.servlet;

import javax.servlet.http.HttpServletRequest;

import bitcamp.java106.pms.server.ServerRequest;

public class ServerRequestAdapter extends ServerRequest {
    HttpServletRequest request;
    
    public ServerRequestAdapter(HttpServletRequest request) {
        super("");
        this.request = request;
    }
    
    // 상속 받은 메서드를 현재 클래스의 역할에 맞게끔 재정의하기 - 오버라이딩(overriding)
    @Override
    public String getParameter(String name) {
        return request.getParameter(name);
    }
    
    @Override
    public String getServerPath() {
        return request.getPathInfo();
    }
    
}





