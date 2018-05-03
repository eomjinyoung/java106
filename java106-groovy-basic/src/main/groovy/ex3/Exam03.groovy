// 메서드 - closure 파라미터와 it 배열
package ex3

// 배열 값을 받을 때 파라미터를 선언하지 않으면 
// 내장 변수 it에 저장된다.
plus = { 
    it[0] + it[1]
}

plus2 = { arr -> 
    arr[0] + arr[1]
}

println plus([100, 200])
println plus2([100, 200])


