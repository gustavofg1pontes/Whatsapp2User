package com.ifsp.whatsapp2user;

import com.ifsp.whatsapp2user.views.View;
import com.ifsp.whatsapp2user.views.ViewSwitcher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class Program extends Application {
    public static Socket socket;


    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setScene(scene);
        ViewSwitcher.setStage(stage);
        ViewSwitcher.switchView(View.CREATE_USER);

        socket = new Socket("localhost", 12345);

        stage.setTitle("Whatsapp 2.0");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        try {
            socket.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}