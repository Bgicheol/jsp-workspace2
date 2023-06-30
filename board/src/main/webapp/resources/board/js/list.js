const modifyBtns = document.querySelectorAll('.modify-btn');
const boardTitle = document.querySelectorAll('.board-title');
const pageBtn = document.getElementsByClassName('page-btn');

for (let i = 0; i < pageBtn.length; ++i) {
	pageBtn[i].addEventListener('click', (e) => {
	location.href=`./list?page=${e.target.dataset.page}`;
	})
}

console.log('btns:', modifyBtns.length);

for (let i = 0; i < boardTitle.length; ++i) {
	boardTitle[i].addEventListener('click', (e) =>{
		location.href=`./detail?id=${e.target.dataset.id}`;
	});
}


for (let i = 0; i < modifyBtns.length; ++i) {
	modifyBtns[i].addEventListener('click', (e) => {
		
		console.log('이벤트 정보', e);
		console.log('눌림버튼 인스턴스', e.target);
		console.log('눌림버튼의 data속성들:', e.target.dataset);
		console.log(e.target.dataset.num);
		
		location.href=`./modify?id=${e.target.dataset.num}`;
	});
	
}
