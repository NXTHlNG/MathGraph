package ru.nxthing.mathgraph.command.general;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.command.graph.GraphCommand;

import java.util.List;
import java.util.Map;

@Component
public class HelpCommand extends AbstractCommand implements GeneralCommand {
    private final Map<String, GraphCommand> graphCommandMap;
    private final Map<String, GeneralCommand> generalCommandMap;
    private final String format = "%-45s %-15s %n";

    public HelpCommand(@Qualifier("graphCommandMap") Map<String, GraphCommand> graphCommandMap,
                       @Lazy @Qualifier("generalCommandMap") Map<String, GeneralCommand> generalCommandMap) {
        super("help", "help", "get info about all commands");
        this.graphCommandMap = graphCommandMap;
        this.generalCommandMap = generalCommandMap;
    }

    @Override
    public void execute(List<String> parameters) {
        generalCommandMap.values().forEach(c -> System.out.format(format, c.getSignature(), c.getDescription()));

        graphCommandMap.values().forEach(c -> System.out.format(format, c.getSignature(), c.getDescription()));
    }
}
