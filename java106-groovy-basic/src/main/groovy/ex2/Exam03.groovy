// 반복문
package ex2

def a = 10
while (a > 0) {
    print a + ","
    a--
}
println ""

for (int i = 0; i < 10; i++)
    print i + ","
println ""

for (i in 0..9)
    print i + ","
println ""

for (i in [100, 200, 300, 400])
    print i + ","
println ""

for (e in ["홍길동":20, "임꺽정":30, "육관순":16])
    println e.key + "=" + e.value

for (c in "123ABC가각간")
    print c + ","
println ""



