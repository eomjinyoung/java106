# Gradle 사용법

## gradle init
- gradle 관련 폴더와 설정파일을 자동으로 생성한다.
```
.gradle 폴더
  - gradle을 실행할 때 사용하는 관련 파일들을 모아둔 폴더이다.
gradle 폴더 
  - gradle 실행 파일을 둔 폴더이다.
build.gradle
  - gradle 설정 파일 
gradlew(unix/linux 용), gradlew.bat(windows 용)
  - 사용자 PC에 gradle을 자동으로 다운로드 받아 설치하고 실행한다.
  - 즉 사용자 PC에 gradle이 설치되어 있지 않아도 실행할 수 있다.  
settings.gradle
  - gradle 실행할 때 참조하는 정보가 들어 있다. 
```

## gradle init --type [프로젝트타입]
지정한 유형에 맞춰 프로젝트 폴더 및 기본 파일들을 자동으로 생성한다.

## gradle tasks --all
gradle로 사용할 수 있는 모든 작업을 출력한다.

## plugin
gradle로 실행할 수 있는 작업들을 모아둔 라이브러리이다.

플러그인을 추가하는 방법: build.gradle 파일에 다음 설정을 추가한다. 
```
방법1:
apply plugin: '플러그인명'

방법2:
plugins {
    id '플러그인명'
}
```

### 'java' 플러그인 
```
> gradle compileJava
```
- build/classes/java/main 폴더를 생성한다.
- src/main/java 폴더의 모든 자바 소스 파일을 컴파일하여 위에서 생성한 폴더에 넣는다.


```
> gradle clean
```
- build 폴더를 제거한다.

```
> gradle processResources
```
- build/resources/main 폴더를 생성한다.
- src/main/resources 폴더의 모든 파일을 복사하여 위의 폴더에 넣는다.


```
> gradle classes
```
- compileJava + processResources 작업 수행

```
> gradle compileTestJava
```
- classes 작업을 먼저 수행
- build/classes/java/test 폴더를 생성한다.
- src/test/java 폴더의 모든 자바 소스 파일을 컴파일하여 위에서 생성한 폴더에 넣는다.

```
> gradle processTestResources
```
- build/resources/test 폴더를 생성한다.
- src/test/resources 폴더의 모든 파일을 복사하여 위의 폴더에 넣는다.

```
> gradle testClasses
```
- compileTestJava + processTestResources 작업을 수행 

```
> gradle test
```
- testClasses 작업을 수행
- build/classes/test 폴더에 있는 테스트 관련 클래스를 모두 실행한다. 

```
> gradle jar
```
- classes 작업 수행
- build/libs 폴더 생성
- 자바 클래스 파일과 기타 자원 파일을 .jar 파일에 묶는다. 그리고 위의 폴더로 복사한다.

### 'application' 플러그인
자바 프로그램을 실행할 수 있는 작업이 들어 있다.

```
gradle run
```
- classes 작업을 먼저 수행한다.
- mainClassName에 지정된 자바 클래스를 실행한다.

### 'eclipse' 플러그인
이클립스 IDE 관련 설정 파일을 다루는 작업들이 들어 있다.

```
> gradle eclipseClasspath
```
- .classpath 파일 생성

```
> gradle eclipseProject
```
- .project 파일 생성

```
> gradle eclipseJdt
```
- JDT(Java Developement Tool)관련 설정 파일 및 폴더 생성 
- .settings 폴더 및 파일 생성

```
> gradle eclipse
```
- eclipseClasspath + eclipseProject + eclipseJdt 작업 수행

```
> gradle cleanEclipseClasspath
```
- .classpath 파일 삭제

```
> gradle cleanEclipseProject
```
- .project 파일 삭제

```
> gradle cleanEclipseJdt
```
- .settings 폴더의 파일 삭제

```
> gradle cleanEclipse
```
- cleanEclipseClasspath + cleanEclipseProject + cleanEclipseJdt 작업 수행







