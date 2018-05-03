// 클래스 정의
package ex4

// groovy는 기본적으로 다음의 패키지를 임포트한다.
// => 따라서 다음 패키지의 클래스를 사용할 때는 import를 할 필요가 없다.
/*
import java.util.*;
import java.math.*;
import java.io.*; 
import java.net.*;
import groovy.lang.*;
import groovy.util.*;
*/
// 클래스를 정의하면 자동으로 groovy.lang.GroovyObject 인터페이스를  
// 구현한다.
class Exam01 {
    void hello() {
        println "안녕하세요!"
    }
}
