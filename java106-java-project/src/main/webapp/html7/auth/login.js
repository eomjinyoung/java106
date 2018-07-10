$("#loginBtn").click(() => {
	var data = {
		id : $("#fId").val(),
		password: $("#fPassword").val()
	};
	if ($(document.body).is("#fSaveId:checked")) {
		data.saveId = "true";
	}
	$.post(serverRoot + "/json/auth/login", data, (result) => {
		if (result.state == "success")
			location.href = "../board/list.html";
		else 
			window.alert("로그인 실패!");
	}, "json");
});
