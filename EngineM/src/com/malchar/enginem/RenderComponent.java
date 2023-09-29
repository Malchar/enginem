package com.malchar.enginem;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RenderComponent extends GameComponent {
	protected static final ImageLoader imageLoader = new ImageLoader();
	protected Group group;
	protected GameLayer gameLayer;
	protected ImageView imageView;
	
	public RenderComponent(ImageData imageData, GameLayer gameLayer) {
		this(gameLayer);
		try (FileInputStream fis = new FileInputStream(GameManager.IMAGE_DIRECTORY + imageData.fileName)) {
			Image sprite = new Image(fis);
			imageView.setImage(sprite);
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * creates a render component with image crossStretched to the given width and height.
	 * @param imageData
	 * @param width
	 * @param height
	 * @param gameLayer
	 */
	public RenderComponent(ImageData imageData, int width, int height, GameLayer gameLayer) {
		this(gameLayer);
		try (FileInputStream fis = new FileInputStream(GameManager.IMAGE_DIRECTORY + imageData.fileName)) {
			Image sprite = new Image(fis);
			
			Image image = imageLoader.crossStretch(sprite, width, height);
			
			imageView.setImage(image);
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	protected RenderComponent(GameLayer gameLayer) {
		this.gameLayer = gameLayer;
		group = new Group();
		imageView = new ImageView();
		group.getChildren().add(imageView);
	}

	@Override
	public void update(GameEntity parent) {
		group.setLayoutX(parent.getX());
		group.setLayoutY(parent.getY());
	}
	
}
