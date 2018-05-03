// 분기문 - switch
package ex2

switch ("500") {
case "aaa": println "aaa 입니다."; break
case 50: println "50 입니다."; break
case [2, 3, 5, 7]: println "소수입니다"; break
case 100..200: println "100 ~ 200 입니다."; break
case Number: println "숫자입니다."; break;
case String: println "문자열입니다."; break;
default: println "기타입니다." 
}




