<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Pizza_Form</title>
<link rel="stylesheet" href="./pizza.css">
</head>
<body>
	
	<div id='main'>
		<div>
			<div>1</div>
			<div id="title">
				<div>
					PERSONAMIZED PIZZA
				</div> 
				<div>
					OrderForm
				</div>			
			</div>
		</div>
		<div id="pizza">
			<button class="button1" onclick='choice(1)'>
			<img src="./image/crust.png"></button>
			<div style="font-size:50px">+</div>
			<button class="button2" onclick='choice(2)'></button>
			<div style="font-size:50px">+</div>
			<button class="button3" onclick='choice(3)'></button>
		</div>
		<form action="http://localhost:8090/chap02/form/pizza_order.jsp">
		<div id="choiceMunu">Topping Choices:</div>
		<div id="options">
			<div id="base" style='display:none;'>
				<input type='radio' id='op1' name='dough' value='original' checked>
	          	<label for='op1'>오리지널</label>
	          	<input type='radio' id='op2' name='dough' value='thin'>
	          	<label for='op2'>씬</label>
	          	<input type='radio' id='op3' name='dough' value='crust'>
	          	<label for='op3'>크러스트</label>		
			</div>
			<br>
			<div id="middle" style='display:none;' >
				<input type='radio' id='op1' name='sauce' value='tomato'checked>
	          	<label for='op1'>Tomato Sauce</label>
	          	<input type='radio' id='op2' name='sauce' value='cream'>
	          	<label for='op2'>Cream Sauce</label>
				<input type='checkbox' id='op3' name='toping' value='Pepperoni'/>
				<label for='op3'>Pepperoni</label>
				<input type='checkbox' id='op4' name='toping' value='Xtra-Cheese'/>
				<label for='op4'>Xtra Cheese</label>
				<input type='checkbox' id='op5' name='toping' value='Onion'/>
				<label for='op5'>Onion</label>
				<br>
				<input type='checkbox' id='op6' name='toping' value='Bacon'/>
				<label for='op6'>Bacon</label>
				<input type='checkbox' id='op7' name='toping' value='Sausage'/>
				<label for='op7'>Sausage</label>
				<input type='checkbox' id='op8' name='toping' value='Olives'/>
				<label for='op8'>Olives</label>
				<input type='checkbox' id='op9' name='toping' value='Pepper'/>
				<label for='op9'>Pepper</label>
				<input type='checkbox' id='op10' name='toping' value='Mushrooms'/>
				<label for='op10'>Mushrooms</label>
			</div>
			<br>
			<div id="top" style='display:none;'>
				<input type='checkbox' id='op1' name='cheese' value='Mozzarella' checked/>
				<label for='op1'>Mozzarella</label>
				<input type='checkbox' id='op2' name='cheese' value='Gouda'/>
				<label for='op2'>Gouda</label>
				<input type='checkbox' id='op3' name='cheese' value='Gorgonzola'/>
				<label for='op3'>Gorgonzola</label>
				<input type='checkbox' id='op4' name='cheese' value='Cheddar'/>
				<label for='op4'>Cheddar</label>
			</div>
		</div>
			</form>
		<input type="submit"/>
	</div>		
	
	
	<script>		
		function choice(n) {
			const base = document.getElementById("base");
			const middle = document.getElementById("middle");
			const top = document.getElementById("top");
					
			if (n == 1){
				base.style.order=-1;
				base.style.display = "";
				middle.style.display ="none";
				top.style.display ="none"				
			} else if (n == 2) {
				middle.style.order=-1;
				base.style.display = "none";
				middle.style.display ="";
				top.style.display ="none"	
			} else if (n == 3) {
				top.style.order=-1;
				base.style.display = "none";
				middle.style.display ="none";
				top.style.display ="";	
			}
		}		
	</script>
</body>
</html>