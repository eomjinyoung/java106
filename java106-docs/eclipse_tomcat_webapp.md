# 이클립스 + 톰캣 + 웹앱 설정

## 이클립스에 톰캣서버가 설치된 경로를 등록한다.
- "이클립스 환경설정 > Server > 런타임 환경" 선택
- 톰캣 서버 경로를 등록한다.
```
톰캣 서버 설치 경로:
c:/Users/사용자명/server/apache-tomcat-9.0.7 
```

## 웹앱 테스트로 사용할 서버 테스트 환경을 구축한다.
- 이클립스 "Servers" 뷰 > 컨텍스트 메뉴의 "new" > "Server" 선택
- 등록된 톰캣의 테스트 환경을 추가한다.
- 서버 테스트 환경의 설정 파일을 관리할 프로젝트가 생긴다.
- 톰캣 서버의 conf 폴더에 있는 설정 파일(*.xml)을 복사하여
  Servers 프로젝트/[테스트환경이름]-config/ 폴더에 복사한다. 
```
서버 테스트 환경 프로젝트:
c:/workspace/Servers/[테스트환경]-config/*.xml

```

## 웹 프로젝트를 생성한다. 
- 이클립스에서 "Dynamic Web Project"를 생성한다.
```
자바 웹 프로젝트 구조:
c:/workspace/[웹프로젝트명]
    /src            <= 자바 소스
    /WebContent     <= JSP, HTML, CSS, JavaScript, GIF, JPEG 등 웹 관련 파일 
        /WEB-INF
            /lib     <= 의존 라이브러리 
            web.xml  <= 배치에 관한 사항을 등록  
    /build/classes   <= 컴파일한 자바 클래스 파일  
    .project         <= 이클립스 프로젝트 설정 파일
    .classpath       <= 소스 파일 경로 및 의존 라이브러리 경로 정보
    /.settings/      <= 이클립스 프로젝트와 관련된 설정 파일
```

## 웹 프로젝트를 테스트 서버에 배치한다.
- 웹 프로젝트를 톰캣 서버에서 실행할 수 있도록 배치한다.
-
```
테스트 서버의 작업 폴더:
c:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0
    /conf     <= 서버 테스트 환경 프로젝트에서 설정 파일을 복사해온다.
                 (c:/workspace/Servers/[테스트환경]-config/*.xml)
    /logs     <= 서버를 실행하는 동안 작업 내용을 기록
    /temp     <= 실행하는 동안 임시 파일을 생성, 삭제하는 폴더
    /webapps  <= 사용하지 않는다.
    /work     <= JSP를 실행할 때, 자동 생성된 자바 소스 파일과 클래스 파일
    /wtpwebapps <= 실제 웹 애플리케이션이 배치되는 폴더
이 폴더는 이클립스의 "Servers" 뷰에서 서버 테스트 환경을 지울 때 함께 제거된다.
주의! 
이 폴더에 내용을 직접 변경하지 말라.
```

## 배치 폴더 규격 
- 자바 웹 애플리케이션을 배치할 때 반드시 다음 구조로 배치해야 한다.
```
웹 애플리케이션 폴더 구조:
wtpwebapps/[웹애플리케이션 폴더]
    /hello     <= 하위 폴더를 생성한다.
    hello.html <= HTML, CSS, JavaScript, GIF, JPEG 등 정적 자원을 저장한다.
    hello.jsp  <= JSP 파일을 둔다.
    /WEB-INF   <= 웹 애플리케이션과 관련된 설정 파일을 두는 폴더.
        /classes    <= 컴파일된 자바 클래스 파일(.class)을 둔다.
                       실행하는 동안 사용할 설정파일을 둘 수도 있다.
                       예) .properties, .xml, .txt 등 
        /lib        <= 의존 라이브러리 파일(.jar)을 둔다.   
        web.xml     <= 웹 애플리케이션의 배치 정보를 담고 있는 파일.            
```











