module com.ifsp.whatsapp2user {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.ifsp.whatsapp2user to javafx.fxml;
    exports com.ifsp.whatsapp2user;
}