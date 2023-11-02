package com.ifsp.whatsapp2user;

public enum View {
    CREATE_USER("create-user.fxml"),
    SEND_MESSAGE("send-message.fxml");

    private String fileName;

    View(String path) {
        this.fileName = path;
    }

    public String getFileName() {
        return fileName;
    }
}
