// groovy 실행 원리
package ex1

// 블록 바깥에 그냥 작성하는 코드는 Exam01의 run() 메서드에 안에 들어간다.
// => Exam01의 main() 메서드에서 run()을 호출한다.
println "Hello!"

// Exam01 클래스에 메서드로 정의된다.
def plus(a, b) {
    a + b
}

sum = plus(10, 20)
println sum