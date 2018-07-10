
if (location.href.split("?").length > 1) {
	var tags = $(".input-view");
    tags.css("display", "none");
    
	var no = location.href.split("?")[1].split("=")[1];
	
	$.getJSON(serverRoot + "/json/board/" + no, function(data) {
        $(fNo).val(data.no);
        $(fTitle).val(data.title);
        $(fContent).val(data.content);
        $(fCreatedDate).val(data.createdDate);
	});
	
	$("#updBtn").click(() => {
		$.post(serverRoot + "/json/board/update", {
			title: $(fTitle).val(),
			content: $(fContent).val(),
			no: $(fNo).val()
		}, () => {
			location.href = "list.html";
		});
	});
	
    $("#delBtn").click(() => {
        if (window.confirm("삭제하시겠습니까?") == false) 
        	return;
        
        $.get(serverRoot + "/json/board/delete", {"no": no}, () => {
        	location.href = "list.html";
        });
	});
	
} else { // 새 글 등록
    var tags = $(".detail-view");
    tags.css("display", "none");
    
    $("#addBtn").click(() => {
    	$.post(serverRoot + "/json/board/add", {
    		title: $(fTitle).val(),
            content: $(fContent).val()
    	}, () => {
    		location.href = "list.html";
    	});
    });
}
