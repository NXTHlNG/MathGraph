package ru.nxthing.mathgraph.command.general;

import ru.nxthing.mathgraph.command.Command;

import java.util.List;

public interface GeneralCommand extends Command {
    void execute(List<String> parameters);
}
