// 역할: 응답에 관련된 도구를 다룬다.
package bitcamp.java106.pms.server;

import java.io.PrintStream;

public class ServerResponse {
    protected PrintStream out;
    
    public ServerResponse(PrintStream out) {
        this.out = out;
    }
    
    public PrintStream getWriter() {
        return this.out;
    }
}

//ver 28 - 클래스 추가




