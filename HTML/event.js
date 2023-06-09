function changeColor(){
    var randomColor = Math.floor(Math.random()*16777215).toString(16);
    document.getElementsByClassName('title-banner')[0].style.color = '#' + randomColor;
}


var currentValue = 0;
var t;

function startCount(){
    currentValue = parseInt(document.getElementById('txtInput').value);
    currentValue = currentValue - 1;

   document.getElementById('txtInput').value = currentValue;
   if(currentValue == 0){
    clearTimeout(t);
    return;
   }
   t = setTimeout("startCount()", 1000);
}


function processCountDown(currentValue){
    document.getElementById('txtInput').value = currentValue
}


function stopCount(){
    clearTimeout(t);
}