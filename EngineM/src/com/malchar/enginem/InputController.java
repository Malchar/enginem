package com.malchar.enginem;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class InputController {

	private boolean leftPressedRaw = false;
	private boolean upPressedRaw = false;
	private boolean rightPressedRaw = false;
	private boolean downPressedRaw = false;
	private boolean yesReleasedRaw = false;
	private boolean noReleasedRaw = false;
	
	public void attachToScene(Scene scene) {
		scene.setOnKeyPressed(event -> {
			KeyCode keyCode = event.getCode();
		switch (keyCode) {
		case LEFT:
			leftPressedRaw = true;
			break;
		case UP:
			upPressedRaw = true;
			break;
		case RIGHT:
			rightPressedRaw = true;
			break;
		case DOWN:
			downPressedRaw = true;
			break;
		default:
			break;
		}
		});
		
		scene.setOnKeyReleased(event -> {
			KeyCode keyCode = event.getCode();
			switch (keyCode) {
			case LEFT:
				leftPressedRaw = false;
				break;
			case UP:
				upPressedRaw = false;
				break;
			case RIGHT:
				rightPressedRaw = false;
				break;
			case DOWN:
				downPressedRaw = false;
				break;
			case ENTER:
				yesReleasedRaw = true;
				break;
			case ESCAPE:
				noReleasedRaw = true;
				break;
			default:
				break;
			}
		});
		
//		scene.setOnKeyTyped(event -> {
//			String keyChar = event.getCharacter();
//			switch (keyChar) {
//			case "\n": // enter key
//				yesButton = true;
//				break;
//			case "\u001B": // escape key
//				noButton = true;
//				break;
//			default:
//				break;
//			}
//		});
	}
	
	public int getDirection() { 
		int base = 5;
		if (leftPressedRaw) base -= 1;
		if (rightPressedRaw) base += 1;
		if (upPressedRaw) base += 3;
		if (downPressedRaw) base -= 3;
		return base;
	}
	
	public boolean isYesButton() { return yesReleasedRaw; }
	public boolean isNoButton() { return noReleasedRaw; }
	
	public void clearButtons() {
		yesReleasedRaw = false;
		noReleasedRaw = false;
	}

}
