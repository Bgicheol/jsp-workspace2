const modifyBtns = document.querySelectorAll('.modifyBtns');

console.log('btns:', modifyBtns.length);

for (let i = 0; i < modifyBtns.length; ++i) {
	modifyBtns[i].addEventListener('click', (e) => {
		
		console.log('이벤트 정보', e);
		console.log('눌림버튼 인스턴스', e.target);
		console.log('눌림버튼의 data속성들:', e.target.dataset);
		console.log(e.target.dataset.num);
		
		location.href='./modiftyBtns=${e.target.dataset.num}';
	});
	
}
