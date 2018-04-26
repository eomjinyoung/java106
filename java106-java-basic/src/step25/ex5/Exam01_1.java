// Data Persistence Framework 도입 - Mybatis
package step25.ex5;

// Data Persistence Framework
// 1) SQL Mapper
//    - 직접 SQL 문을 작성
//    - 각각의 DBMS에 최적화된 SQL을 작성할 수 있다.
//    - DBMS마다 미미하게 다른 SQL을 작성해야 하는 번거로움이 있다. 
//    - 예) Mybatis 등
// 2) OR Mapper
//    - 전용언어 및 문법(Domain-Specific Language;DSL)을 사용하여 작성
//      실행할 때 DBMS에 맞춰서 SQL을 생성하여 실행한다.
//    - DBMS에 마다 SQL문을 작성할 필요가 없어 편리하다.
//    - DBMS에 최적화된 SQL을 실행할 수 없다.
//      즉 DBMS의 특징을 최대로 활용할 수 없다.
//    - 예) Hibernate, TopLink 등 
//
// Mybatis 도입
// 1) 의존 라이브러리 추가
//    - mvnrepository.com 검색하여 build.gradle 파일에 추가한다.
//    - "gradle eclipse" 실행한 후 이클립스 에디터에서 프로젝트를 "refresh" 한다.
// 2) mybatis 설정 파일 준비
//    - mybatis-config.xml 생성 및 편집
// 3) DB 연결 정보를 담은 프로퍼티 파일 준비
//    - jdbc.properties 생성 및 편집
// 4) SQL 문장을 작성할 파일 준비
//    - BoardMapper.xml 생성 및 편집
// 
public class Exam01_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
