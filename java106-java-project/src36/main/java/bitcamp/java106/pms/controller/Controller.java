// App과 컨트롤러 사이에 호출 규칙
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

public interface Controller {
    void service(ServerRequest request, ServerResponse response);
}

//ver 28 - service() 의 규칙 변경
//ver 21 - 인터페이스 추가