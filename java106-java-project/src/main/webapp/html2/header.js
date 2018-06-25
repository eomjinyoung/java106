// div#header 태그에 /html/header.html 내용을 삽입한다.
var xhr = new XMLHttpRequest();
xhr.open("GET", "/java106-java-project/html/header.html", false); // 동기 방식으로 요청한다. 
xhr.send();
header.innerHTML = xhr.responseText; // 서버로부터 받은 header를 페이지에 삽입한다.

// 로그인 정보를 가져와서 span#username 태그에 사용자 아이디를 삽입한다.
var xhr = new XMLHttpRequest();
xhr.open("GET", "/java106-java-project/json/auth/loginUser", false);
xhr.send();
if (xhr.responseText == "") {
	location.href = "/java106-java-project/html/auth/login.html";
} else {
	var data = JSON.parse(xhr.responseText);
	username.textContent = data.id;
}