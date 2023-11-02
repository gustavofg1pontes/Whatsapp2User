package com.ifsp.whatsapp2user.models.commands;

public record CreateUserCommand (
        String command,
        String name
) {

    public static CreateUserCommand from(String name){
        return new CreateUserCommand(Commands.CREATE_USER, name);
    }
}
