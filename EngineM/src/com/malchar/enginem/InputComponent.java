package com.malchar.enginem;

public class InputComponent extends GameComponent {

	private int speed = 10;
	
	@Override
	public void update(GameEntity parent) {
		int direction = GameManager.input.direction;
		
		if (direction % 3 == 0) parent.setVelocityX(speed);
		else if (direction % 3 == 1) parent.setVelocityX(-speed);
		else parent.setVelocityX(0);
		
		if (direction >= 7) parent.setVelocityY(-speed);
		else if (direction <= 3) parent.setVelocityY(speed);
		else parent.setVelocityY(0);
		
		if (GameManager.input.yes) {
			System.out.println(parent.getX() + ", " + parent.getY());
		}
	}

}
