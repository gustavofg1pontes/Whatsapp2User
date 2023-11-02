package com.ifsp.whatsapp2user.controllers;

import com.google.gson.Gson;
import com.ifsp.whatsapp2user.Program;
import com.ifsp.whatsapp2user.models.commands.CreateUserCommand;
import com.ifsp.whatsapp2user.views.View;
import com.ifsp.whatsapp2user.views.ViewSwitcher;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.PrintWriter;

public class CreateUserController {

    @FXML
    private TextField nameField;

    @FXML
    public void createUser() {
        try {
            PrintWriter out = new PrintWriter(Program.socket.getOutputStream(), true);
            Gson gson = new Gson();
            CreateUserCommand command = CreateUserCommand.from(nameField.getText());
            out.println(gson.toJson(command));

            ViewSwitcher.switchView(View.CHAT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
