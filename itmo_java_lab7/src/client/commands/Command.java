package client.commands;

import client.RequestSender;

import java.util.Scanner;

public abstract class Command {
    protected RequestSender requestSender;
    protected Scanner scanner;

    public Command() {}
    public Command(RequestSender requestSender) {
        this.requestSender = requestSender;
    }
    public Command(RequestSender requestSender, Scanner scanner) {
        this.requestSender = requestSender;
        this.scanner = scanner;
    }

    public abstract String getName();
    public abstract String getDescription();
    public abstract void execute(String stringArgument);

    public boolean canExecuteIfNotAuthed() {
        return false;
    }
}
