package ru.nxthing.mathgraph.command;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.general.GeneralCommand;
import ru.nxthing.mathgraph.command.graph.GraphCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;
import java.util.Map;

@Component
public class CommandRegistry {
    private final Map<String, GraphCommand> graphCommandMap;
    private final Map<String, GeneralCommand> generalCommandMap;

    public CommandRegistry(@Qualifier("graphCommandMap") Map<String, GraphCommand> graphCommandMap,
                           @Qualifier("generalCommandMap") Map<String, GeneralCommand> generalCommandMap) {
        this.graphCommandMap = graphCommandMap;
        this.generalCommandMap = generalCommandMap;
    }


    public void execute(String commandName, List<String> commandParameters, MathGraph graph) {
        if (graphCommandMap.containsKey(commandName)) {
            graphCommandMap.get(commandName).execute(graph, commandParameters);
        } else if (generalCommandMap.containsKey(commandName)) {
            generalCommandMap.get(commandName).execute(commandParameters);
        } else {
            System.out.println("Invalid command, type help to see all available commands");
        }
    }
}
