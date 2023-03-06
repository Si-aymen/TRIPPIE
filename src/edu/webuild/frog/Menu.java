/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.frog;

 

import java.io.IOException;
import java.io.InputStream;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.animation.AnimationTimer;

import javafx.application.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;

/**
 *
 * @author mtirn
 */
public class Menu extends Application{
    
    
	 private Button startButton;
         private Pane root;
         private AnimationTimer timer;
	private Parent createContent() {
		 root = new Pane(); // initialize root here
		
		root.setPrefSize(1050, 600); //Screen size
		//add background image
		try(InputStream is = Files.newInputStream(Paths.get("src/edu/webuild/resources/bg.png"))){
			ImageView img = new ImageView(new Image(is));
			img.setFitWidth(1050);
			img.setFitHeight(600);
			root.getChildren().add(img);
		}
		catch(IOException e) {
			System.out.println("Couldn't load image");
		}
		
		Title title = new Title ("TRIPPIE");
		title.setTranslateX(50);
		title.setTranslateY(200);
		
                 
                
		this.root = root; // set root field

                initStartButton(); // initialize start button
		return root;
                
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("VIDEO GAME");
		primaryStage.setScene(scene);
               
		primaryStage.show();
                
               
	}
	
	private static class Title extends StackPane{
		public Title(String name) {
			Rectangle bg = new Rectangle(375, 60);
			bg.setStroke(Color.WHITE);
			bg.setStrokeWidth(2);
			bg.setFill(null);
			
			Text text = new Text(name);
			text.setFill(Color.WHITE);
			text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));
			
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg,text);
		}
	}
	
	

	
		
     private void initStartButton() {
         
    startButton = new Button("Start");
    
   
    startButton .setStyle(
            "-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
    
    startButton.setOnMouseEntered(e -> {
    startButton.setStyle( "-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
});
    

startButton.setOnMouseExited(e -> {
    startButton.setStyle( "-fx-background-color: #6143F7; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
});

 startButton.setOnMouseEntered(e -> {
    startButton.setStyle( "-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
});
    
    startButton.setOnAction(event -> {
        try {
            FroggerApp game = new FroggerApp(); // create an instance of the game
            Stage gameStage = new Stage(); // create a new stage for the game
            game.start(gameStage); // start the game in the new stage
            ((Stage) root.getScene().getWindow()).close(); // close the menu window
        } catch (Exception e) {
            e.printStackTrace();
        }
    });

    HBox hBox = new HBox();
    hBox.setTranslateX(800);
    hBox.setTranslateY(300);
    hBox.getChildren().add(startButton);

    root.getChildren().add(hBox);
}

	public static void main(String[] args) {
		
		launch(args);
                
	}
}