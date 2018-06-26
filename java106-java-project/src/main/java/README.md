# 변경 내역
- build.gradle 변경
- /WEB-INF/spring/application-context.xml 추가
- /WEB-INF/spring/json-servlet.xml 추가
- /WEB-INF/spring/dispatcher-servlet.xml 변경
- /WEB-INF/web.xml 변경 
- bitcam.java106.pms.web.json 패키지 생성
- *.json.BoardController 클래스 추가
- webapp/html/board/list.html 생성 
- webapp/html/board/form.html 생성
- webapp/html/header.html 생성
- webapp/html/header.js 생성   

## javascript 라이브러리 정의
- webapp/html2/js/bitcamp.js 생성
- webapp/html2/board/list.html 변경
- webapp/html2/board/form.html 변경
- webapp/html2/auth/login.html 변경
- webapp/html2/header.js 변경
- webapp/html2/js/bitcamp.min.js 생성

## jQuery javascript 라이브러리 사용(CDN 방식)
- bitcamp.js, bitcamp.min.js 제거
- webapp/html3/board/list.html 변경
- webapp/html3/board/form.html 변경
- webapp/html3/auth/login.html 변경
- 장점
  - 같은 URL에서 다운로드 받은 자바스크립트 라이브러리는 캐시에 보관되기 때문에 다시 다운로드 받지 않아서 
    HTML 페이지의 로딩 속도가 빠르다.
- 단점
  - 외부에 라이브러리 파일이 있기 때문에 통제할 수 없다. 
  - 보안에 취약할 수 있다. 

## jQuery javascript 라이브러리 사용(서버에 다운로드하는 방식)
- webapp/html4/board/list.html 변경
- webapp/html4/board/form.html 변경
- webapp/html4/auth/login.html 변경
- 장점
  - 사용할 자바스크립트 라이브러리를 내부 서버에 보관하기 때문에 보안에 좋다.
  - 임의로 통제할 수 있다.
  - 외부 서버로 접속이 막혀있더라도 사용이 가능하다.
- 단점
  - 같은 라이브러리도 사이트가 다르면 다시 다운로드 해야 한다.
  - 페이지 로딩 속도가 느려질 수 있다. 

## jQuery javascript 라이브러리 사용(라이브러리 파일 자동 다운로드)
- gradle 처럼 자바스크립트 라이브러리도 자동으로 다운로드 할 수 있다.
  - npm(node package manager)를 사용하라!
  - npm 외에 bower 등도 존재하지만 현재는 npm 사용으로 모이는 추세다.
- webapp/html5/board/list.html 변경
- webapp/html5/board/form.html 변경
- webapp/html5/auth/login.html 변경

## bootsrap 라이브러리 사용
- package.json 변경
- webapp/html6/board/list.html 변경
- webapp/html6/board/form.html 변경
- webapp/html6/auth/login.html 변경







