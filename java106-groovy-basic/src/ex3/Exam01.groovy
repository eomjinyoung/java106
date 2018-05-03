// 메서드
package ex3

int plus(int a, int b) {
    return a + b;
}

def plus2(a, b) {
    a + b
}

println plus(100, 200)
println plus2(100, 200)

// 메서드를 호출할 때 괄호 없이 파라미터를 전달할 수 있다.
sum = plus 100, 200
println sum 

sum = plus2 100, 200
println sum

