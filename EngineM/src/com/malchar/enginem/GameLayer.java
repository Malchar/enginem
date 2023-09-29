package com.malchar.enginem;

public enum GameLayer {
	background(0),
	grass(1),
	boulder(2),
	entityMinus(3),
	entity(4),
	entityPlus(5),
	leaf(6),
	top(7);

	final int value;
	
	GameLayer(int value) {
		this.value = value;
	}
}
