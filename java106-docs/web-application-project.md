# 웹 애플리케이션 프로젝트 만들기

## 이클립스 전용 웹 프로젝트 :  Dynamic Web Project
- 이클립스에서 인식할 수 있는 웹 애플리케이션 프로젝트이다. 
- 이클립스 만의 프로젝트 구조를 갖는다.
- 다른 IDE 개발 도구와 호환되지 않는다. 
- 즉 다른 IDE에서 이클립스 프로젝트를 불러올 수 없다. 
```
[웹프로젝트]
    /src           <= 자바 소스 파일 및 설정 파일(.xml, .properties 등)을 두는 폴더
    /WebContent    <= JSP, HTML, CSS, JavaScript 등 정적 파일을 두는 폴더
    /build/classes <= 컴파일된 자바 클래스 파일을 두는 폴더
    .project       <= 이클립스에 제공할 프로젝트 정보를 둔다.
    .classpath     <= 작업하고 실행하는 동안 사용할 의존 라이브러리 파일(.jar)을 둔다.
    /.settings     <= 이클립스 전용 프로젝트 관련 설정 파일을 둔다.
```

## Maven 웹 프로젝트 
- 실무에서 사용하는 웹 프로젝트 구조이다.
- 특정 IDE에 종속되지 않는다.
- Android Studio의 기본 빌드 도구인 "Gradle"도 이 구조를 프로젝트 구조로 사용한다.
```
[Maven 웹 프로젝트]
    /src/main/java      <= 자바 소스파일(.java)
             /resources <= 설정 파일 (.properties, .xml, .txt 등)
             /webapp    <= 웹 관련 정적 파일(.html, .css, .js, .gif, .jpeg, .jsp 등)
        /test/java      <= 단위 테스트 관련 자바 소스 파일
             /resources <= 단위 테스트 관련 설정 파일
    build.gradle        <= Gradle 빌드 도구가 사용할 설정 파일
    pom.xml             <= Maven 빌드 도구가 사용할 설정 파일
```

## Gradle을 이용하여 Maven 웹 프로젝트 만들기
프로젝트 폴더 준비 
```
프로젝트 폴더 생성:
> mkdir web01
> cd web01

프로젝트 하위 폴더 및 설정 파일 생성:
> gradle init --type java-application
```

Gradle "build.gradle" 파일 편집
```
이클립스 웹 프로젝트 관련 관련 플러그인 추가:
apply plugin: 'eclipse-wtp'

war 파일 관련 플러그인 추가:
apply plugin: 'war'

servlet-api 의존 라이브러리 추가:
providedCompile group: 'javax.servlet', name: 'javax.servlet-api', version: '4.0.1'
```

이클립스 관련 파일 생성:
```
> gradle eclipse
```

이클립스 IDE로 웹 프로젝트를 임포트한다.












