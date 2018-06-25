// 자바스크립트 함수를 모아 놓은 라이브러리
var bitcamp = new Object();

bitcamp.ajax = (url, settings) => {
	// AJAX 실행 정보를 초기화시킨다.
	if (settings == undefined || settings == null) {
		settings = {};
	} 
	
	if (settings.method == undefined) settings.method = "GET";
	if (settings.dataType == undefined) settings.dataType = "text";
	
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
	    if (xhr.readyState == 4) {
	        if (xhr.status == 200) {
	        	if (settings.success == undefined) 
	        		return;
	        	
	        	// 서버에서 받은 데이터를 호출자가 원하는 대로 변환해서 
	        	// success()를 호출할 때 파라미터로 넘겨 준다.
	        	if (settings.dataType == "text")
	        		settings.success(xhr.responseText);
	        	else if (settings.dataType == "json")
	                settings.success(JSON.parse(xhr.responseText));
	        } else {
	        	if (settings.error) 
	        		settings.error();
	        }
	    }
	};
	xhr.open(settings.method, url, true);
	if (settings.method == "POST") {
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		var qs = "";
		if (settings.data) {
			for (var key in settings.data) {
				if (qs.length > 0) qs += "&";
				qs += key + "=" + encodeURIComponent(settings.data[key]);
			}
		}
		xhr.send(qs);
		
	} else { // GET 
		xhr.send();
	}	
};

bitcamp.getJSON = (url, p1, p2) => {
	// 호출 예:
	if (p1 == undefined || typeof p1 != "function") {
		// => getJSON("board/list");
		// => getJSON("board/list", {pageNo:1,pageSize:5});
		// => getJSON("board/list", {pageNo:1,pageSize:5}, function(data) {...});
	    bitcamp.ajax(url, {
	    	"data": p1,
	    	"dataType": "json",
	    	"success": p2
	    });
	} else if (typeof p1 == "function") {
		// => getJSON("board/list", function() {});
		bitcamp.ajax(url, {
			"dataType": "json",
	    	"success": p1
	    });
	}
};

var $ = bitcamp;












