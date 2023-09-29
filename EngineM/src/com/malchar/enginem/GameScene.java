package com.malchar.enginem;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class GameScene {
	List<GameEntity> gameEntities;
	Group[] groups = new Group[GameLayer.values().length];
	
	public GameScene(List<GameEntity> gameEntities) {
		this.gameEntities = gameEntities;
	}
	
	public void update() {
		for (GameEntity ge : gameEntities) {
			ge.update();
		}
	}

	public Pane createPane() {
		// initialize and attach containers
		Pane root = new Pane();
		for (int i = 0; i < groups.length; i++) {
			groups[i] = new Group();
			// lower index groups are added first for layering
			root.getChildren().add(groups[i]);
		}
		
		// add entities' renderComponents to the correct layer
		for (GameEntity gameEntity : gameEntities) {
			for (GameComponent gameComponent : gameEntity.getGameComponents()) {
				if (gameComponent instanceof RenderComponent) {
					RenderComponent renderComponent = (RenderComponent)gameComponent;
					groups[renderComponent.gameLayer.value].getChildren().add(renderComponent.group);
				}
			}
		}
		
		return root;
	}

}
