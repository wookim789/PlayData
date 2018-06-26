/**
 * 2018-06-17 김경우
 */
$(document).ready(function(){
	
	var recentStack  = new Array();
	function arrayStack(recentStack){
	
		for(var i = 0; i < recentStack.length;i++){
			$(".recentList:nth-child(" + (i+1) + ')').text(recentStack[recentStack.length-i-1]);
		}
	}
	function chekStack(recentStack, text){
		if(recentStack.length==4){
			recentStack.shift();
			recentStack.push(text);
		}else{
			recentStack.push(text);
		}
	}
	
	// 마우스가 오버 되었을 때
	$('.menuTitle').on("mouseover",function(){
		$(".innerMenu").slideDown();
	});
	
	// 마우스가 나갔을 때
	$(".innerMenu").on("mouseleave", function(){
		$(".innerMenu").slideUp();
	});
	
	//네비게이션바 html링크 선택시 ARTICLE 부분 문서 불러오기
	$(".innerMenuItem1:nth-child(1)").on("click", function(){
		
		$.ajax({
			url: "../html/htmlMenu1.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				console.log($(".innerMenuItem1:nth-child(1)").text());
				chekStack(recentStack,$(".innerMenuItem1:nth-child(1)").text());
				arrayStack(recentStack);
				
			}
		});
	});
	$(".innerMenuItem1:nth-child(2)").on("click", function(){
		$.ajax({
			url: "../html/htmlMenu2.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				console.log($(".innerMenuItem1:nth-child(2)").text());
				chekStack(recentStack,$(".innerMenuItem1:nth-child(2)").text());
				arrayStack(recentStack);
			}
		});
	});
	$(".innerMenuItem1:nth-child(3)").on("click", function(){
		$.ajax({
			url: "../html/htmlMenu3.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				console.log($(".innerMenuItem1:nth-child(3)").text());
				chekStack(recentStack,$(".innerMenuItem1:nth-child(3)").text());
				arrayStack(recentStack);
			}
		});
	});
	
	//네비게이션바 css링크 선택시 ARTICLE 부분 문서 불러오기
	$(".innerMenuItem2:nth-child(1)").on("click", function(){
		$.ajax({
			url: "../html/css1.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				chekStack(recentStack,$(".innerMenuItem2:nth-child(1)").text());
				arrayStack(recentStack);
			}
		});
	});
	$(".innerMenuItem2:nth-child(2)").on("click", function(){
		$.ajax({
			url: "../html/css2.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				chekStack(recentStack,$(".innerMenuItem2:nth-child(2)").text());
				arrayStack(recentStack);
			}
		});
	});
	$(".innerMenuItem2:nth-child(3)").on("click", function(){
		$.ajax({
			url: "../html/css3.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				chekStack(recentStack,$(".innerMenuItem2:nth-child(3)").text());
				arrayStack(recentStack);
			}
		});
	});
	
	//네비게이션바 js링크 선택시 ARTICLE 부분 문서 불러오기
	$(".innerMenuItem3:nth-child(1)").on("click", function(){
		$.ajax({
			url: "../html/javascript1.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				chekStack(recentStack,$(".innerMenuItem3:nth-child(1)").text());
				arrayStack(recentStack);
			}
		});
	});
	$(".innerMenuItem3:nth-child(2)").on("click", function(){
		$.ajax({
			url: "../html/javascript2.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				chekStack(recentStack,$(".innerMenuItem3:nth-child(2)").text());
				arrayStack(recentStack);
			}
		});
	});
	$(".innerMenuItem3:nth-child(3)").on("click", function(){
		$.ajax({
			url: "../html/javascript3.html",
			type: "get",
			dataType: "html",
			success: function(e) {
				$(".article1").html(e);
				chekStack(recentStack,$(".innerMenuItem3:nth-child(3)").text());
				arrayStack(recentStack);
			}
		});
	});
	$(".recentList:nth-child(1)").on("click", function(){
		console.log('a');
		for(var i = 1; i <=3; i++){
			for(var j =1; j <=3; j++){
				if($(".innerMenuItem"+i+':nth-child('+j+')').text()==$(".recentList:nth-child(1)").text()){
					console.log($(".recentList:nth-child(1)").text());
					console.log($(".innerMenuItem"+i+':nth-child('+j+')').text());
					var abc;
					if(i==1){
						abc = "../html/htmlMenu"+j+'.html';			
					}else if(i ==2){
						abc ="../html/css"+j+'.html';	
					}else{
						abc ="../html/javascript"+j+'.html';	
					}
					
					$.ajax({
						url: abc,
						type: "get",
						dataType: "html",
						success: function(e) {
							$(".article1").html(e);
						}
					});
				}
			}
			
		}
		
	});
	$(".recentList:nth-child(2)").on("click", function(){
		console.log('a');
		for(var i = 1; i <=3; i++){
			for(var j =1; j <=3; j++){
				if($(".innerMenuItem"+i+':nth-child('+j+')').text()==$(".recentList:nth-child(2)").text()){
					console.log($(".recentList:nth-child(2)").text());
					console.log($(".innerMenuItem"+i+':nth-child('+j+')').text());
					var abc;
					if(i==1){
						abc = "../html/htmlMenu"+j+'.html';			
					}else if(i ==2){
						abc ="../html/css"+j+'.html';	
					}else{
						abc ="../html/javascript"+j+'.html';	
					}
					
					$.ajax({
						url: abc,
						type: "get",
						dataType: "html",
						success: function(e) {
							$(".article1").html(e);
						}
					});
				}
			}
			
		}
		
	});
	$(".recentList:nth-child(3)").on("click", function(){
		console.log('a');
		for(var i = 1; i <=3; i++){
			for(var j =1; j <=3; j++){
				if($(".innerMenuItem"+i+':nth-child('+j+')').text()==$(".recentList:nth-child(3)").text()){
					console.log($(".recentList:nth-child(3)").text());
					console.log($(".innerMenuItem"+i+':nth-child('+j+')').text());
					var abc;
					if(i==1){
						abc = "../html/htmlMenu"+j+'.html';			
					}else if(i ==2){
						abc ="../html/css"+j+'.html';	
					}else{
						abc ="../html/javascript"+j+'.html';	
					}
					
					$.ajax({
						url: abc,
						type: "get",
						dataType: "html",
						success: function(e) {
							$(".article1").html(e);
						}
					});
				}
			}
			
		}
		
	});
	$(".recentList:nth-child(4)").on("click", function(){
		console.log('a');
		for(var i = 1; i <=3; i++){
			for(var j =1; j <=3; j++){
				if($(".innerMenuItem"+i+':nth-child('+j+')').text()==$(".recentList:nth-child(4)").text()){
					console.log($(".recentList:nth-child(4)").text());
					console.log($(".innerMenuItem"+i+':nth-child('+j+')').text());
					var abc;
					if(i==1){
						abc = "../html/htmlMenu"+j+'.html';			
					}else if(i ==2){
						abc ="../html/css"+j+'.html';	
					}else{
						abc ="../html/javascript"+j+'.html';	
					}
					
					$.ajax({
						url: abc,
						type: "get",
						dataType: "html",
						success: function(e) {
							$(".article1").html(e);
						}
					});
				}
			}
			
		}
		
	});
	
	
	// 마우스가 오버 되었을 때
	$('.inputSearchSubmit').on("mouseover",function(){
		$(".inputSearchSubmit").css("backgroundColor",'#075248');
	});
	
	// 마우스가 나갔을 때
	$(".inputSearchSubmit").on("mouseleave", function(){
		$(".inputSearchSubmit").css("backgroundColor",'#0D9987');
	});
	
	/*$(".inputSearchSubmit").on("click", function(){
		var length = $('innerMenuItem1').size().to;
		
		for(int i = 0; i < length; i++){
			if($('innerMenuItem1').text()==$('inputSearch').text()){
				
			}
			
		}
		length = $('innerMenuItem2').length;
		length = $('innerMenuItem3').length ;
	});*/
	

	
	
});

