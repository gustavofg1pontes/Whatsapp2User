package com.ifsp.whatsapp2user.controllers;

import com.google.gson.Gson;
import com.ifsp.whatsapp2user.Program;
import com.ifsp.whatsapp2user.models.message.Message;
import com.ifsp.whatsapp2user.models.commands.SendMessageCommand;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChatController {
    @FXML
    private TextField messageField;
    @FXML
    private VBox chatScreen;

    @FXML
    public void sendMessage() {
        try {
            PrintWriter out = new PrintWriter(Program.socket.getOutputStream(), true);
            Gson gson = new Gson();
            SendMessageCommand command = SendMessageCommand.from(messageField.getText());
            out.println(gson.toJson(command));
            addLabel(messageField.getText(), Pos.CENTER_RIGHT);
            messageField.setText("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        new Thread(() -> {
            try {
                while(true) {
                    BufferedReader in =
                            new BufferedReader(new InputStreamReader(Program.socket.getInputStream()));
                    Gson gson = new Gson();
                    Message message = gson.fromJson(in.readLine(), Message.class);

                    addLabel(message.toString(), Pos.CENTER_LEFT);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void addLabel(String message, Pos position) {
        HBox hBox = new HBox();
        hBox.setAlignment(position);
        hBox.setPadding(new Insets(5, 5, 5, 10));

        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);

        switch (position){
            case CENTER_LEFT -> {
                textFlow.setStyle("-fx-background-color: rgb(255,255,255);" +
                        "-fx-background-radius: 20px");
            }
            case CENTER_RIGHT -> {
                textFlow.setStyle("-fx-background-color: rgb(18, 140, 126);" +
                        "-fx-background-radius: 20px");
            }
        }

        textFlow.setPadding(new Insets(5, 10, 5, 10));

        hBox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatScreen.getChildren().add(hBox);
            }
        });
    }
}
