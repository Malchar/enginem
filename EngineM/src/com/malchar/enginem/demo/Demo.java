package com.malchar.enginem.demo;

import com.malchar.enginem.GameManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Demo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Basic Engine");		
		GameManager gameManager = new GameManager(primaryStage);
		gameManager.startGame();
	}

}
