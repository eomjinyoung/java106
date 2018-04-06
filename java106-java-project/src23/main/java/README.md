# 변경 내역
- annotation 패키지 생성
- Component.java 추가
- context 패키지 생성
- ApplicationContext.java 추가
- 모든 DAO와 컨트롤러에 @Component 애노테이션을 붙인다.
- 컨트롤로 중에서 의존 객체를 자체적으로 만드는 경우,
  외부에서 주입받도록 변경한다.
- App.java 변경
