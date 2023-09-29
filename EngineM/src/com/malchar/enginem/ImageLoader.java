package com.malchar.enginem;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ImageLoader {
	
	/**
	 * helper function crops an image to the specified dimensions
	 * @param spriteSheet
	 * @param x
	 * @param y
	 * @param frameWidth
	 * @param frameHeight
	 * @return
	 */
	public Image createFrame(Image spriteSheet, int x, int y, int frameWidth, int frameHeight) {
		Canvas canvas = new Canvas(frameWidth, frameHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.drawImage(spriteSheet, -x, -y);
		
		SnapshotParameters sp = new SnapshotParameters();
		sp.setFill(Color.TRANSPARENT);
		return canvas.snapshot(sp, null);
	}
	
	public Image crossStretch(Image original, int targetWidth, int targetHeight) {
		Image temp = sideStretch("width", original, targetWidth);
		return sideStretch("height", temp, targetHeight);
	}
	
	public Image sideStretch(String sideName, Image original, int targetLength) {
		boolean isWidth = sideName.equals("width"); 
		if (!isWidth && !sideName.equals("height")) throw new IllegalArgumentException("sideName must be \"width\" or \"height\".");
		
		int canvasWidth, canvasHeight;
		int targetWidth, targetHeight, sourceX, sourceY, sourceWidth, sourceHeight;
		int sideWidth, sideHeight, farSideSourceX, farSideSourceY, farSideTargetX, farSideTargetY;
		if (isWidth) {
			canvasWidth = targetLength;
			canvasHeight = (int) original.getHeight();
			targetHeight = canvasHeight;
			sourceX = -1 + (int) ((original.getWidth() + 1.5) / 2);
			sourceY = 0;
			sourceWidth = 1;
			sourceHeight = targetHeight;
			sideWidth = sourceX;
			sideHeight = targetHeight;
			targetWidth = targetLength - 2 * sideWidth;
			farSideSourceX = sourceX + sourceWidth;
			farSideSourceY = sourceY;
			farSideTargetX = sourceX + targetWidth;
			farSideTargetY = sourceY;
		}
		else {
			canvasWidth = (int) original.getWidth();
			canvasHeight = targetLength;
			targetWidth = canvasWidth;
			sourceX = 0;
			sourceY = -1 + (int) ((original.getHeight() + 1.5) / 2);
			sourceWidth = targetWidth;
			sourceHeight = 1;
			sideWidth = targetWidth;
			sideHeight = sourceY;
			targetHeight = targetLength - 2 * sideHeight;
			farSideSourceX = sourceX;
			farSideSourceY = sourceY + sourceHeight;
			farSideTargetX = sourceX;
			farSideTargetY = sourceY + targetHeight;
		}
		Canvas canvas = new Canvas(canvasWidth, canvasHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		// draw stretched section
		gc.drawImage(original, sourceX, sourceY, sourceWidth, sourceHeight, sourceX, sourceY, targetWidth, targetHeight);
		// draw near side
		gc.drawImage(original, 0, 0, sideWidth, sideHeight, 0, 0, sideWidth, sideHeight);
		// draw far side
		gc.drawImage(original, farSideSourceX, farSideSourceY, sideWidth, sideHeight, farSideTargetX, farSideTargetY, sideWidth, sideHeight);
		
		SnapshotParameters sp = new SnapshotParameters();
		sp.setFill(Color.TRANSPARENT);
		return canvas.snapshot(sp, null);
	}
}
