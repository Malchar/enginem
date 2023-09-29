package com.malchar.enginem;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * current problems:
 */

public class GameManager {
	public static final String IMAGE_DIRECTORY = "src/com/malchar/resources/images/";
	public static final int FPS = 10;
	public static final boolean DEBUG_INPUT = true;
	
	private Stage primaryStage;
	private GameScene currentGameScene;
	private GameScene[] gameScenes;
	private InputController inputController = new InputController();
	static InputHolder input = new InputHolder();
	private EntityLoader entityLoader = new EntityLoader();
	
	public GameManager(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		gameScenes = entityLoader.createGameObjects();
		
		loadGameScene(gameScenes[0]);
	}
	
	private void loadGameScene(GameScene gameScene) {
		currentGameScene = gameScene;
		Pane root = currentGameScene.createPane();		
		Scene scene = new Scene(root, 400, 300);
		inputController.attachToScene(scene);
		primaryStage.setScene(scene);
	}

	public void startGame() {		
		// Create a game loop
		AnimationTimer gameLoop = new AnimationTimer() {
			private final long updateInterval = 1_000_000_000l / FPS;
			private long lastUpdateTime = 0;
			@Override
			public void handle(long now) {
				long elapsedTime = now - lastUpdateTime;
				if (elapsedTime >= updateInterval) {
					
					// Update game state
					input.receiveInput(inputController);
					currentGameScene.update();
					GameComponent.swap();
					inputController.clearButtons();
					
					elapsedTime -= updateInterval;
					lastUpdateTime = now;
				}
				
			}
		};
		gameLoop.start();
		primaryStage.show();
	}

}
