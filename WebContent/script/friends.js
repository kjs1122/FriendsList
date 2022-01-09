/**
 * 
 */

function check(){
	if(document.frm.name.value.length == 0){
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	}
	if(document.frm.age.value.length == 0){
		alert("나이를 입력하세요");
		frm.age.focus();
		return false;
	}
	if(document.frm.relation.value.length == 0){
		alert("관계를 입력하세요");
		frm.relation.focus();
		return false;
	}
	if(document.frm.job.value.length == 0){
		alert("직업을 입력하세요");
		frm.job.focus();
		return false;
	}
	if(document.frm.phone.value.length == 0){
		alert("전화번호를 입력하세요");
		frm.phone.focus();
		return false;
	}
	return true;
}

function win_open(url,name) {
	window.open(url,name,'width=500px,height=200px');
	
}
function win_close() {
	window.close();
}