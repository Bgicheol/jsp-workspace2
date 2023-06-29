const modifyBtns = document.querySelectorAll('.modifyBtns');

console.log('btns:', modifyBtns.length);

for (let i = 0; i < modifyBtns.length; ++i) {
	modifyBtns[i].addEventListener('click', (e) => {
		
		// data-* 로 시작하는 html 속성을 자바스크립트에서 꺼내 쓰도록 설계되어있다. 
		console.log('이벤트정보', e);
		console.log('눌림버튼 인스턴스', e.target);
		console.log('눌림버튼의 data속성들:', e.target.dataset);
		console.log(e.target.dataset.num);
		console.log(e.target.dataset.birthday);
		
		location.hred = './modifyBtns=${e.target.dataset.num}';
	});
}