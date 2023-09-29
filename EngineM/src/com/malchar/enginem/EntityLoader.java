package com.malchar.enginem;

import java.util.ArrayList;
import java.util.List;

public class EntityLoader {

	public GameScene[] createGameObjects() {
		// entity A
		AnimationData[] adA = {new AnimationData("animGreen.png", 50, 50, 2), new AnimationData("animGreenM.png", 50, 50, 2)};
		AnimationComponent acA = new AnimationComponent(adA, GameLayer.entityMinus);
		RenderComponent rcA = new RenderComponent(new ImageData("ring.png", 25, 25), GameLayer.entityPlus);
		InputComponent icA = new InputComponent();
		MovementComponent mcA = new MovementComponent();
		GameComponent[] componentsA = { rcA, acA, icA, mcA };
		GameEntity entityA = new GameEntity("green", componentsA);
		
		// entity B
		AnimationData[] adB = { new AnimationData("animRed.png", 50, 50, 2) };
		AnimationComponent acB = new AnimationComponent(adB, GameLayer.boulder);
		GameComponent[] componentsB = { acB };
		GameEntity entityB = new GameEntity("red", componentsB);
		
		// entity C
		ImageData idC = new ImageData("bluebg.png", 200, 200);
		RenderComponent rcC = new RenderComponent(idC, GameLayer.background);
		GameComponent[] componentsC = { rcC };
		GameEntity entityC = new GameEntity("blue", componentsC);
		
		// entity D
		AnimationData[] adD = { new AnimationData("animGreen.png", 50, 50, 2) };
		AnimationComponent acD = new AnimationComponent(adD, GameLayer.entity);
		GameComponent[] componentsD = { acD };
		GameEntity entityD = new GameEntity("green D", componentsD);
		
		// textbox 1
		ImageData idTb1 = new ImageData("ui.png", 11, 11);
		RenderComponent rcTb1 = new RenderComponent(idTb1, 200, 100, GameLayer.top);
		GameComponent[] componentsTb1 = { rcTb1 };
		GameEntity textbox1 = new GameEntity("textbox1", componentsTb1);
		
		// initialize
		entityA.setX(100);
		entityA.setY(100);
		entityD.setX(150);
		entityD.setY(150);
		textbox1.setX(25);
		textbox1.setY(195);
		
		// add entities to list
		List<GameEntity> ge = new ArrayList<GameEntity>();
		ge.add(entityA);
		ge.add(entityB);
		ge.add(entityC);
		ge.add(entityD);
		ge.add(textbox1);
		
		// create containers
		GameScene[] gameScenes = new GameScene[1];
		gameScenes[0] = new GameScene(ge);
		return gameScenes;
	}
}
