// 변수 선언
package ex1

// 타입을 지정하지 않으면 동적 타입 바인딩을 수행한다.
// => 즉 값을 넣을 때 변수의 타입이 결정된다.
def a = 20   // map.put("a", 20);
println a

a = "Hello"  // map.put("a", "Hello");
println a

// def 를 붙이는 것은 선택사항이다.
b = 3.14
println b

// 변수의 타입을 명시하면 정적 타입 바인딩으로 작동한다.
int c = 20
println c

// 다른 타입의 값을 넣으면 오류이다.
//c = "Hello"
//println c

String d = "Hello"
d = 20 // 정수값 20이 "20"이라는 문자열로 변경되어 d 변수에 저장된다.
println d

// 변수를 선언할 때 자바 문법을 그대로 사용할 수 있다.
java.util.Date today = new java.util.Date()
println today

// groovy는 java.util 패키지를 기본으로 import 한다.
Date today2 = new Date()
println today2









