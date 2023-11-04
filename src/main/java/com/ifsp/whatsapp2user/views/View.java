package com.ifsp.whatsapp2user.views;

public enum View {
    CREATE_USER("create-user.fxml", 280, 150),
    CHAT("chat.fxml", 400, 400);

    private String fileName;
    private Integer width, height;

    View(String fileName, Integer width, Integer height) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }

    public String getFileName() {
        return fileName;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
