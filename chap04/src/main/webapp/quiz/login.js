const login = document.getElementById("login");
const signup = document.getElementById("signup");
const check = document.getElementById("check");
const regist = document.getElementById("regist");
const user_id = document.getElementById("userid");
const user_pw = document.getElementById("userpw")
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const id_arr = [];


login.addEventListener('click' , () => {
	if (localStorage.getItem(id.value) == pw.value){
		location.href='./main.jsp'
	} else {
		alter("아이디 또는 비밀번호가 틀렸습니다")
		return;
	}
	
});
check.addEventListener('click', () => {
	console.log(user_id.value)
	for (i = 0; i < id_arr.length; ++i) {
		if (user_id.value == id_arr[i]){
			alter('중복된 아이디 입니다');
			break;
		} else {
			alter('사용가능한 아이디입니다');
		}
	}	
});
regist.addEventListener('click', () => {
	id_arr.push(user_id.value)
	localStorage.setItem(user_id.value, user_pw.value)	
	location.href='./login.jsp';
})
signup.addEventListener('click', () => {
	location.href='./signup.jsp'
});