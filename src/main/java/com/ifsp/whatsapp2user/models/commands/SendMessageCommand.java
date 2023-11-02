package com.ifsp.whatsapp2user.models.commands;

public record SendMessageCommand (
        String command,
        String message
){
    public static SendMessageCommand from(String message){
        return new SendMessageCommand(Commands.SEND_MESSAGE, message);
    }

}
