package ru.nxthing.mathgraph.utils;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class ParsedCommand {
    private final String commandName;
    private final List<String> parameters;

    private ParsedCommand(String commandName, List<String> parameters) {
        this.commandName = commandName;
        this.parameters = parameters;
    }

    public static ParsedCommand parse(String commandMessage) {
        String[] commandSplit = commandMessage.trim().split("\\s+");
        return new ParsedCommand(commandSplit[0].toLowerCase(), Arrays.asList(Arrays.copyOfRange(commandSplit, 1, commandSplit.length)));
    }
}
