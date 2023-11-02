module com.ifsp.whatsapp2user {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens com.ifsp.whatsapp2user to javafx.fxml;
    exports com.ifsp.whatsapp2user;
    exports com.ifsp.whatsapp2user.controllers;
    opens com.ifsp.whatsapp2user.controllers to javafx.fxml;
    exports com.ifsp.whatsapp2user.views;
    opens com.ifsp.whatsapp2user.views to javafx.fxml;
    exports com.ifsp.whatsapp2user.models.message;
    exports com.ifsp.whatsapp2user.models.commands;
}