var nums = 6;
var colors = [];
var targetColor;
var choices = document.querySelectorAll(".choice");
var resultDisplay = document.querySelector("#result");
var h1 = document.querySelector("h1");
var newGameButton = document.querySelector("#newGame");

init();

function init(){
	setupChoices();
	newGame();
}

function setupChoices(){
	for(var i = 0; i < choices.length; i++){
		choices[i].addEventListener("click", function(){
			var chosenColor = this.style.background;
			//compare color to the targetColor
			if(chosenColor === targetColor){
				resultDisplay.textContent = "You got it!";
				newGameButton.textContent = "Guess Again?"
				changeColors(chosenColor);
				h1.style.background = chosenColor;
			} else {
				this.style.background = "black";
				resultDisplay.textContent = "One More Guess"
			}
		});
	}
}



function newGame(){
	colors = ["white", "blue", "red", "gold","green", "gray"];
	//set a random color in colors array as the target color
	targetColor = setColor();
	newGameButton.textContent = "New Game"
	resultDisplay.textContent = "";
	//change colors of choices buttons
	for(var i = 0; i < choices.length; i++){
		if(colors[i]){
			choices[i].style.display = "block"
			choices[i].style.background = colors[i];
		} else {
			choices[i].style.display = "none";
		}
	}
	h1.style.background = "blue";
}

newGameButton.addEventListener("click", function(){
	newGame();
})

function setColor(){
	var random = Math.floor(Math.random() * colors.length);
	return colors[random];
}

function changeColors(color){
	//loop through all choices
	for(var i = 0; i < choices.length; i++){
		//change each color to the given color
		choices[i].style.background = color;
	}
}
