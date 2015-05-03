var ctrl = false;

inputField.onkeydown = function(event) {
	if(event.keyCode == 17)
		ctrl = true;
	else if(ctrl && event.keyCode == 13) {
		ctrl=false;
		sendButton.onclick();
	}
};