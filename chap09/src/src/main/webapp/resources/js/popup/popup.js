// opener : 이 창을 연 부모 객체
console.log(opener);
console.log(opener.document.getElementById("addr"));

opener.document.getElementById('addr').value = 'holy moly';
opener.document.body.style.backgroundColor="gray";