# 변경 내역
- 기존의 annotation 패키지 및 Component.java 제거
- 기존의 context 패키지 및 ApplicationContext.java 제거
- build.gradle 변경
    - spring-context 라이브러리 추가
    - "gradle eclipse" 실행 및 프로젝트 갱신
- DAO 및 컨트롤러에서 사용한 Component 애노테이션을 스프링 라이브러리에 있는 것으로 교체한다. 
- AppConfig.java 추가
    - 스프링 설정 작업을 수행하는 클래스 작성
    - 이 클래스에서 SqlSessionFactory 객체를 만든다. 
- DefaultApplicationContainer.java 변경





