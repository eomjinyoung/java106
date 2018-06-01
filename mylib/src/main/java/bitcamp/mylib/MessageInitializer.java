// 웹 개발자와 라이브러리 개발자 사이의 규칙
package bitcamp.mylib;

import java.util.Map;

// 웹 개발자 이 규칙에 따라 클래스를 만들어 놓으면, 
// 라이브러리 개발자는 이 규칙에 따라 만든 클래스를 실행한다. 
// 즉 onStartup()을 호출한다.
public interface MessageInitializer {
    void onStartup(Map<String,String> msgMap);
}
