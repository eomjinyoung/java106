// div#header 태그에 /html/header.html 내용을 삽입한다.
$.get("/java106-java-project/html2/header.html", (data) => {
	$("#header").html(data);
	loadLoginUser();
});

function loadLoginUser() {
	$.getJSON("/java106-java-project/json/auth/loginUser", (data) => {
		if (data == "") 
			location.href = "/java106-java-project/html2/auth/login.html";
		else 
			$("#username").text(data.id);
	});
}