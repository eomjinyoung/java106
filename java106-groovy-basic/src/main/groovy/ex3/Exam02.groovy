// 메서드 - closure
package ex3

plus = {int a, int b -> 
    return a + b;
}

plus2 = {a, b -> 
    a + b // return을 생략하면 마지막 문장의 실행 값이 리턴된다.
}

println plus(100, 200)
println plus2(100, 200)



