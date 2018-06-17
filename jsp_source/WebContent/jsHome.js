/** 2018/06/13 home work home page
 * 
 */

window.onload = function(){
	var idChecker =  document.getElementById('idInput');
	idChecker.onkeypress = function(e){
		console.log(e.keyCode);	
		if(
				!(
						(47 < e.keyCode && e.keyCode < 58)||
						(64 < e.keyCode && e.keyCode < 91)||
						(96 < e.keyCode && e.keyCode < 123)||
						(e.keyCode == 16 ||e.keyCode ==9)
		         )
		   )
		{
			console.log('실행');
			alert("특수기호 불가");
		}
	}
	

	var pwChecker1 =  document.getElementById('pwInputText');
	pwChecker1.onkeypress = function(e){
		console.log(e.keyCode);	
		if(
				!(
						(47 < e.keyCode && e.keyCode < 58)||
						(64 < e.keyCode && e.keyCode < 91)||
						(96 < e.keyCode && e.keyCode < 123)||
						(e.keyCode == 16 ||e.keyCode ==9)
		         )
		   )
		{
			console.log('실행');
			alert("특수기호 불가");
		}
	}



	var pwChecker2 =  document.getElementById('pwCheckInputText');
	pwChecker2.onkeypress = function(e){
		console.log(e.keyCode);	
		if(
				!(
						(47 < e.keyCode && e.keyCode < 58)||
						(64 < e.keyCode && e.keyCode < 91)||
						(96 < e.keyCode && e.keyCode < 123)||
						(e.keyCode == 16 ||e.keyCode ==9)
		         )
		   )
		{
			console.log('실행');
			alert("특수기호 불가");
		}
	}
	
	var Check =  document.getElementsByName('CheckInput');

	Check[0].onclick = function(e){
		console.log('1');
		Check[1].checked = false;
	}
	Check[1].onclick = function(e){
		console.log('2');
		Check[0].checked = false;
	}
	
	
	var phoneText1 = document.getElementById('phFInputText');
	phoneText1.onkeypress = function(e){
		console.log(e.keyCode);
		if(!(47 < e.keyCode && e.keyCode < 58)){
			alert("숫자만 가능");
		}
	}
	
	var phoneText2 = document.getElementById('phSInputText');	
	phoneText2.onkeypress = function(e){
		console.log(e.keyCode);
		if(!(47 < e.keyCode && e.keyCode < 58)){
			alert("숫자만 가능");
		}
	}
	
	var phoneText3 = document.getElementById('phTInputText');
	phoneText3.onkeypress = function(e){
		console.log(e.keyCode);
		if(!(47 < e.keyCode && e.keyCode < 58)){
			alert("숫자만 가능");
		}
	}
	
	
	var idInputText1 = document.getElementById('pIdFisInputText');
	idInputText1.onkeypress = function(e){
		console.log(e.keyCode);
		if(!(47 < e.keyCode && e.keyCode < 58)){
			alert("숫자만 가능");
		}
	}
	
	var idInputText2 = document.getElementById('pIdSecInputText');
	idInputText2.onkeypress = function(e){
		console.log(e.keyCode);
		if(!(47 < e.keyCode && e.keyCode < 58)){
			alert("숫자만 가능");
		}
	}
	
	
	var idBut = document.getElementById('ok');
	idBut.onclick = function(e){
		if(idInput.value == ''){
			alert('아이디 입력');
			return;
		}
		if(pwInputText.value ==''){
			alert('페스워드 입력');
			return;
		}
		if(pwCheckInputText.value ==''){
			alert('페스워드 확인 입력');
			return;
		}
		if(pwInputText.value != pwCheckInputText.value){
			alert('페스워드 확인 ');
			return;
		}
		if(pIdFisInputText.value ==''||pIdSecInputText.value =='' ){
			alert('주민번호 입력 ');
			return;
		}
		if(maleCheck.checked == false && femaleCheck.checked ==false){
			alert('성별 입력 ');
			return;
		}
		if(phFInputText.value ==''|| phSInputText.value ==''|| phTInputText.value==''){
			alert('전화번호 입력 ');
			return;
		}
		if(email.value ==''){
			alert('이메일 입력 ');
			return;
		}
		
		var a =0;
		var b =1;
		var tot=0;
		var idtext = pIdFisInputText.value + pIdSecInputText.value;
	
		for(var i = 0; i < 12; i++){
			if(a ==0 && b ==9){
				b = 2;
				a++;
			}else if(a ==1&&b ==5){
				break;
			}else{
				b++;
			}
			console.log(idtext[i] + ' x ' + b);
			tot = tot + parseInt(idtext[i]) * b;
			
		}
		console.log(tot%11);
		if(11 - tot%11 == idtext[12]){
			alert('승인');
		}else if (11 - tot%11 == 10 ){
			if(0 == idtext[12]){
				alert('승인');
			}
			
		}
		else if (11 - tot%11 == 11 ){
			if(1 == idtext[12]){
				alert('승인');
			}
		}
		else{
			alert('주민번호 확인');
		}
	}
	
	
	
	
}
