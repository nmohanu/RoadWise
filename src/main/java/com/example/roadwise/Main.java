package com.example.roadwise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        Scene loginScene = new Scene(root, Color.WHITESMOKE);
        loginScene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        stage.setTitle("RoadWise");
        stage.setResizable(false);

        stage.setScene(loginScene);
        stage.show();
    }
}