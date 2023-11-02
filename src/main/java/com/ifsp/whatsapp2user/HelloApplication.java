package com.ifsp.whatsapp2user;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(HelloApplication.class.getResource("send-message.fxml")), 320, 240);
        ViewSwitcher.switchScene(scene);

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("send-message.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);*/

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}