// 역할: 서버 요청 정보를 다룬다. 
package bitcamp.java106.pms.server;

import java.util.HashMap;

public class ServerRequest {
    
    protected String path;
    protected HashMap<String,String> paramMap = new HashMap<>();
    
    public ServerRequest(String requestLine) {
        // requestLine의 예) /board/add?title=aaa&content=bbb
        
        String[] arr = requestLine.split("\\?");
        
        this.path = arr[0]; // 예) /board/add
        if (arr.length > 1) {
            toParamMap(arr[1]);
        }
    }
    
    private void toParamMap(String queryString) {
        // queryString 예) title=aaa&content=bbb
        // 데이터는 key와 value로 분리하여 맵에 저장한다.
        String[] entryArr = queryString.split("&");
        
        for (String entry : entryArr) {
            String[] keyValue = entry.split("=");
            this.paramMap.put(keyValue[0], keyValue[1]);
        }
    }
    
    public String getServerPath() {
        return this.path;
    }
    
    public String getParameter(String name) {
        return paramMap.get(name);
    }
}

//ver 28 - 클래스 추가




