// 자바스크립트 함수를 모아 놓은 라이브러리
var jQuery = function(param) {
	var tags;
	if (param instanceof HTMLElement) {
		// 파라미터 값이 일반 태그라면 배열에 담고 도우미 함수를 붙여서 리턴한다. 
		tags = [param];
	} else if (param.startsWith("<")) {
        var tagName = param.substr(1, param.length - 2); // <pre> ==> 0, (5-2)
        tags = [document.createElement(tagName)];
    } else if (param.startsWith(".")) {
    	tags = document.querySelectorAll(param);
    } else if (param.startsWith("#")) {
    	tags = [document.querySelector(param)];
    }
    
    tags.html = function(value) {
    	for (var tag of tags) {
    		tag.innerHTML = value;
    	}
    	return tags;
    };
    
    tags.appendTo = function(parent) {
    	for (var tag of tags) {
    		parent.appendChild(tag);
    	}
    	return tags;
    };
    
    tags.css = function(styleName, value) {
    	for (var tag of tags) {
    		tag.style[styleName] = value;
    	}
    	return tags;
    };
    
    tags.val = function(value) {
    	if (arguments.length == 0) {
    		return tags[0].value;
    	}
    	for (var tag of tags) {
    		tag.value = value;
    	}
    	return tags;
    };
    
    tags.click = function(listener) {
    	for (var tag of tags) {
    		tag.addEventListener("click", listener);
    	}
    	return tags;
    };
    
    return tags;
};

jQuery.ajax = function(url, settings) {
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

jQuery.getJSON = function(url, p1, p2) {
	// 호출 예:
	if (p1 == undefined || typeof p1 != "function") {
		// => getJSON("board/list");
		// => getJSON("board/list", {pageNo:1,pageSize:5});
		// => getJSON("board/list", {pageNo:1,pageSize:5}, function(data) {...});
	    jQuery.ajax(url, {
	    	"data": p1,
	    	"dataType": "json",
	    	"success": p2
	    });
	} else if (typeof p1 == "function") {
		// => getJSON("board/list", function() {});
		jQuery.ajax(url, {
			"dataType": "json",
	    	"success": p1
	    });
	}
};

jQuery.post = function(url, p1, p2, p3) {
	var settings = {
		method: "POST"
	};
	if (arguments.length == 2) {
		if (typeof p1 == "function") settings.success =  p1;
		else if (typeof p1 == "string") settings.dataType= p1;
		else settings.data = p1;
	} else if (arguments.length == 3) {
		if (typeof p2 == "function") {
			// .post(url, data, function);
			settings.data = p1;
			settings.success = p2;
		} else if (typeof p2 == "string") {
			settings.dataType = p2;
			if (typeof p1 == "function") settings.success = p1; // .post(url,function,dataType)
			else settings.data = p1; // .post(url, data, dataType);
		} 
	} else if (arguments.length == 4) {
		// .post(url, data, function, dataType);
		settings.data = p1;
		settings.success = p2;
		settings.dataType = p3;
	}
	
	jQuery.ajax(url, settings);
};

var $ = jQuery;












