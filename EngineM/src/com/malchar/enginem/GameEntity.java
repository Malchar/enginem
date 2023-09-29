package com.malchar.enginem;

public class GameEntity {
	private GameComponent[] gameComponents;
	private String name;
	private int x, y, velocityX, velocityY;

	public GameComponent[] getGameComponents() {return gameComponents;}
	public String getName() {return name;}
	
	public int getX() {return x;}
	public int getY() {return y;}
	public int getVelocityX() {return velocityX;}
	public int getVelocityY() {return velocityY;}

	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setVelocityX(int velocityX) {this.velocityX = velocityX;}
	public void setVelocityY(int velocityY) {this.velocityY = velocityY;}

	public GameEntity(String name, GameComponent[] gameComponents) {
		this.name = name;
		this.gameComponents = gameComponents;
	}
	
	public void update() {
		for (GameComponent gameComponent : gameComponents) {
			gameComponent.update(this);
		}
	}

}
