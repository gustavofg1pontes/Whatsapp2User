package com.ifsp.whatsapp2user.views;

import com.ifsp.whatsapp2user.Program;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewSwitcher {
    public static Scene scene;
    public static Stage stage;

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    public static void setStage(Stage stage) {
        ViewSwitcher.stage = stage;
    }

    public static void switchView(View view) {
        try {
            Parent root = FXMLLoader.load(Program.class.getResource(view.getFileName()));
            scene.setRoot(root);
            stage.setHeight(view.getHeight());
            stage.setWidth(view.getWidth());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
