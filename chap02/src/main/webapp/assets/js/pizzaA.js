const options =document.getElementsByClassName('options');
const options_arr = [];
const option_btns = document.getElementsByClassName('option-btns');

const CRUST = 0;
const TOPPING = 1;
const CHEESE = 2;

for (i = 0; i < options.length; ++i) {
	options_arr.push(options[i]);
}

option_btns[CRUST].addEventListener('click', () => {viewOption(CRUST)});
option_btns[TOPPING].addEventListener('click', () => {viewOption(TOPPING)});
option_btns[CHEESE].addEventListener('click', () => {viewOption(CHEESE)});
function viewOption(num) {
	options_arr.forEach((option) => {
		option.style.display = 'none';
	});
	options_arr[num].style.display = 'grid';
}

viewOption(CRUST);
