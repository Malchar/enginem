package com.malchar.enginem;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.image.Image;

public class AnimationComponent extends RenderComponent {

	final private Image[][] frameCatalog;
	private int animation[] = new int[BUFFER_SIZE];
	private int frame[] = new int[BUFFER_SIZE];
	
	public AnimationComponent(AnimationData[] animationData, GameLayer gameLayer) {
		super(gameLayer);
		
		// load images
		frameCatalog = createImages(animationData);
		
		// set image
		imageView.setImage(frameCatalog[animation[current]][frame[current]]);
	}
	
	@Override
	public void update(GameEntity parent) {
		/*
		 * WRITE to next()
		 * READ from current
		 */
		
		// switch parent.getState
		// case "walking": currentAnimation = 1;
		// case "running": currentAnimation = 2;
		if (parent.getVelocityX() != 0 || parent.getVelocityY() != 0) animation[next()] = 1;
		else animation[next()] = 0;
		
		// advance frame, update image
		frame[next()] = (frame[current] + 1) % frameCatalog[animation[current]].length;
		imageView.setImage(frameCatalog[animation[current]][frame[current]]);
		super.update(parent);
	}
	
	/**
	 * load sprite sheets from filename into 2d array
	 * @param animationData
	 * @return
	 */
	private Image[][] createImages(AnimationData[] animationData) {
		Image[][] frames = new Image[animationData.length][];
		for (int i = 0; i < animationData.length; i++) {
			
			try (FileInputStream fis = new FileInputStream(GameManager.IMAGE_DIRECTORY + animationData[i].fileName)) {
				Image spriteSheet = new Image(fis);
				frames[i] = new Image[animationData[i].frameCount];
				for (int j = 0; j < frames[i].length; j++) {
					frames[i][j] = imageLoader.createFrame(spriteSheet, j * animationData[i].frameWidth, 0, animationData[i].frameWidth, animationData[i].frameHeight);
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		return frames;
	}



}
