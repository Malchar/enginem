package com.malchar.enginem;

public abstract class GameComponent {
	static int current = 0;
	static int next() { return 1 - current; }
	final static int BUFFER_SIZE = 2;

	/**
	 * the buffer swap pattern currently only makes sense for the fields of components.
	 * values stored in the (parent) game entity are not swap-able right now.
	 */
	public static void swap() {
		current = next();
	}
	
	public abstract void update(GameEntity parent);
}
