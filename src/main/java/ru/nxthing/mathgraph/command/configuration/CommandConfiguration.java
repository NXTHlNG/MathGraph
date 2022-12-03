package ru.nxthing.mathgraph.command.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nxthing.mathgraph.command.general.GeneralCommand;
import ru.nxthing.mathgraph.command.graph.GraphCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CommandConfiguration {
    @Bean
    public Map<String, GraphCommand> graphCommandMap(List<GraphCommand> commandList) {
        Map<String, GraphCommand> map = new HashMap<>();

        for (GraphCommand command : commandList) {
            map.put(command.getName(), command);
        }

        return map;
    }

    @Bean
    public Map<String, GeneralCommand> generalCommandMap(List<GeneralCommand> commandList) {
        Map<String, GeneralCommand> map = new HashMap<>();

        for (GeneralCommand command : commandList) {
            map.put(command.getName(), command);
        }

        return map;
    }
}

