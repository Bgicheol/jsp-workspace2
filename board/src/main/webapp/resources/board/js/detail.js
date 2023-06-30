const modifyBtn = document.querySelector('#modify-btn');
const listBtn = document.getElementById('list-btn');

modifyBtn.addEventListener('click', (e) => {
	location.href=`./modify?id=${e.target.dataset.id}`;
});

listBtn.addEventListener('click', (e) => {
 
	location.href=`./list`;
	console.log('변함');
});