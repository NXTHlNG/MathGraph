package ru.nxthing.mathgraph.command.general;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;

import java.util.List;

@Component
public class ExitCommand extends AbstractCommand implements GeneralCommand {

    public ExitCommand() {
        super("exit", "exit", "close application");
    }

    @Override
    public void execute(List<String> parameters) {
        System.exit(0);
    }
}
