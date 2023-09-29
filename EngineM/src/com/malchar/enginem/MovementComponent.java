package com.malchar.enginem;

public class MovementComponent extends GameComponent {

	@Override
	public void update(GameEntity parent) {
		parent.setX(parent.getX() + parent.getVelocityX());
		parent.setY(parent.getY() + parent.getVelocityY());
	}

}
