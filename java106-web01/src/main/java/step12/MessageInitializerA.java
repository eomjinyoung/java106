package step12;

import java.util.Map;

import bitcamp.mylib.MessageInitializer;

public class MessageInitializerA implements MessageInitializer{

    @Override
    public void onStartup(Map<String, String> msgMap) {
        System.out.println("MessageInitializerA.onStartup()");
        msgMap.put("title", "제목입니다");
        msgMap.put("content", "내용입니다");
    }

}
