package com.malchar.enginem.demo;

import java.io.FileInputStream;
import java.io.IOException;

import com.malchar.enginem.GameManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MoveImageWithArrowKeys extends Application {
    private ImageView imageView;
    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage primaryStage) {
    	
    	Image image = null;
    	
    	try (FileInputStream fis = new FileInputStream(GameManager.IMAGE_DIRECTORY + "bluebg.png")) {
    		image = new Image(fis);
		} catch(IOException e) {
			e.printStackTrace();
		}	

        // Create an ImageView for the image
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);

        Pane root = new Pane(imageView);

        Scene scene = new Scene(root, 800, 600);

        scene.setOnKeyPressed(this::moveImage);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Move Image with Arrow Keys");
        primaryStage.show();
    }

    private void moveImage(KeyEvent event) {
        KeyCode keyCode = event.getCode();
        double speed = 10.0;

        switch (keyCode) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            default:
                return;
        }

        imageView.setX(x);
        imageView.setY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}