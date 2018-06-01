# 버전 별 주제

## src03 - ContextLoaderListener 사용
- ContextLoaderListener 설정하기
- 작업
    - web.xml 에 ContextLoaderListener 등록
    - /WEB-INF/app-context.xml 생성
    - vo.Board 생성
    - dao.BoardDao 생성
    - /board/add.jsp
    - /board/list.jsp
    
- 학습
    - 프론트 컨트롤러들이 공유하는 객체는 ContextLoaderListener를 사용하여 관리할 수 있다.

## src02 - 멀티 프론트 컨트롤러 설정
- URL에 따라 여러 개의 프론트 커트롤러를 설정
- 작업
  - web.xml 변경
  - /WEB-INF/json-servlet.xml 생성
  - bitcamp.mvc.web.json.HelloController 생성
- 학습
  - URL 별로 프론트 컨트롤러를 분리하여 페이지 컨트롤러들을 관리할 수 있다.
  
## src01 - 프론트 컨트롤러 설정
- XML 기반으로 프론트 컨트롤러 설정하기
- 작업
  - web.xml 생성
  - DispatcherServlet 등록
  - /WEB-INF/dispatcher-servlet.xml 생성
  - /index.html 생성
  - bitcamp.mvc.web.HelloController 생성
- 학습
  - DispatcherServlet은 프론트 컨트롤러 역할을 수행한다.
  - DispatcherServlet은 내부적으로 IoC 컨테이너를 보유하고 있다. 
    그래서 IoC 컨테이너의 설정파일이 필요하다.
  - DispatcherServlet은 다음 규칙에 따라 만든 IoC 컨테이너의 설정 파일을 자동으로 찾는다.
       /WEB-INF/[서블릿별명]-servlet.xml
       
