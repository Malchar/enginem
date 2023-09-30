package com.malchar.enginem.demo;

import com.malchar.enginem.InputController;
import com.malchar.enginem.InputHolder;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameLoopExample extends Application {
	public static final int FPS = 1;
	private Pane root;
	private Rectangle player;
	private InputController inputController = new InputController();
	InputHolder input = new InputHolder();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Game Loop Example");

		root = new Pane();
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);

		player = new Rectangle(50, 50, 30, 30);
		root.getChildren().add(player);

		inputController.attachToScene(scene);

		// Create a game loop
		AnimationTimer gameLoop = new AnimationTimer() {
			private final long updateInterval = 1_000_000_000l / FPS;
			private long lastUpdateTime = 0;
			@Override
			public void handle(long now) {
				long elapsedTime = now - lastUpdateTime;
				if (elapsedTime >= updateInterval) {
					// Update game state
					update();
					elapsedTime -= updateInterval;
					lastUpdateTime = now;
				}
				
			}
		};

		gameLoop.start();

		primaryStage.show();
	}

	private void update() {
		input.receiveInput(inputController);
		
		// Update game objects
		if (input.direction % 3 == 1) player.setX(player.getX() - 10);
		else if (input.direction % 3 == 0) player.setX(player.getX() + 10);
		if (input.yes) System.out.println(player.getX());
		
		inputController.clearButtons();
	}
}