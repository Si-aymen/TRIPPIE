/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.frog;

 import edu.webuild.controllers.BuyAbonnementController;


import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import javafx.animation.AnimationTimer;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;     
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;

/**
 *
 * @author mtirn
 */
public class Menu extends Application{
    


	 private Button startButton;
         private Button howItWorksButton;
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
		
		
                 
                
		this.root = root; // set root field

                initStartButton(); // initialize start button
                initHowItWorksButton();
                initBuyMembershipButton(); // initialize buy membership button
              

		return root;
                
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		Scene scene = new Scene(createContent());
		primaryStage.setTitle("VIDEO GAME");
		primaryStage.setScene(scene);
               
		primaryStage.show();
                FroggerApp app = new FroggerApp();
               int highScore = app.getHighScore();
               Label highScoreLabel = new Label(  highScore + "Tokens:"+" Available on your Wallet ");
                highScoreLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
                highScoreLabel.setTextFill(Color.BLUE);
                highScoreLabel.setLayoutX(660);
                highScoreLabel.setLayoutY(60);
                root.getChildren().add(highScoreLabel);


                
               
	}
	
	
	
	

	
		
     private void initStartButton() {
         
    startButton = new Button("Earn Tokens");
    
   
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
    hBox.setTranslateX(470);
    hBox.setTranslateY(300);
    hBox.getChildren().add(startButton);

    root.getChildren().add(hBox);
}
    private void initHowItWorksButton() {
    howItWorksButton = new Button("How It Works");

    howItWorksButton.setStyle(
            "-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");

    howItWorksButton.setOnMouseEntered(e -> {
        howItWorksButton.setStyle( "-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
    });

    howItWorksButton.setOnMouseExited(e -> {
        howItWorksButton.setStyle( "-fx-background-color: #6143F7; -fx-text-fill: white; -fx-font-size: 14px;"
                + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
    });

    howItWorksButton.setOnAction(event -> {
        // create a new popup window
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(root.getScene().getWindow());
        popup.setTitle("How It Works");
            
        // create a VBox to hold the instructions
        VBox instructions = new VBox();
        instructions.setAlignment(Pos.CENTER);
        instructions.setSpacing(20);

        // add instructions to the VBox
        Text instruction1 = new Text("Use arrow keys to move the frog");
        Text instruction2 = new Text("Avoid cars  to reach the other side");
        Text instruction3 = new Text("Cross the Road quickly to improve your score");

        instruction1.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        instruction2.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        instruction3.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        instructions.getChildren().addAll(instruction1, instruction2, instruction3);

        // create a button to close the popup window
        Button closeButton = new Button("Close");
        closeButton.setOnAction(closeEvent -> popup.close());

        // add the VBox and the Close button to the popup window
        VBox popupContent = new VBox(instructions, closeButton);
        popupContent.setAlignment(Pos.CENTER);
        popupContent.setSpacing(20);

        // create a scene for the popup window and add the popupContent to it
        Scene popupScene = new Scene(popupContent, 400, 200);

        // set the scene of the popup window and show it
        popup.setScene(popupScene);
        popup.showAndWait();
    });

    HBox hBox = new HBox();
    hBox.setTranslateX(465);
    hBox.setTranslateY(350);
    hBox.getChildren().add(howItWorksButton);

    root.getChildren().add(hBox);
}
private void initBuyMembershipButton() {
    Button buyMembershipButton = new Button("Buy Membership");

    buyMembershipButton.setStyle(
            "-fx-background-color: #A08EF9; -fx-text-fill: white; -fx-font-size: 14px;"
                    + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");

    buyMembershipButton.setOnMouseEntered(e -> {
        buyMembershipButton.setStyle( "-fx-background-color: #2F2078; -fx-text-fill: white; -fx-font-size: 14px;"
                + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
    });

    buyMembershipButton.setOnMouseExited(e -> {
        buyMembershipButton.setStyle( "-fx-background-color: #6143F7; -fx-text-fill: white; -fx-font-size: 14px;"
                + " -fx-font-weight: bold; -fx-padding: 10px 20px; -fx-border-radius: 5px;");
    });

    buyMembershipButton.setOnAction(event -> {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/webuild/gui/BuyAbonnementController.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        BuyAbonnementController buyAbonnementController = new BuyAbonnementController();
        buyAbonnementController.buyabonnement(event);
        }
        catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    });

    HBox hBox = new HBox();
    hBox.setTranslateX(465);
    hBox.setTranslateY(400);
    hBox.getChildren().add(buyMembershipButton);

    root.getChildren().add(hBox);
}



	public static void main(String[] args) {
		
		launch(args);
                
	}
}