package com.malchar.enginem;

public class AnimationData extends ImageData {
	int frameCount;
	
	public AnimationData(String fileName, int frameWidth, int frameHeight, int frameCount) {
		super(fileName, frameWidth, frameHeight);
		this.frameCount = frameCount;
	}
}
