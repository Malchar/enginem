package com.malchar.enginem;

public class InputHolder {

	public int direction = 5;
	public boolean yes = false;
	public boolean no = false;

	public void receiveInput(InputController inputController) {
		direction = inputController.getDirection();
		yes = inputController.isYesButton();
		no = inputController.isNoButton();
	}

}
