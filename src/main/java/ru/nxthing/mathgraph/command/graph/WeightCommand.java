package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class WeightCommand extends AbstractCommand implements GraphCommand {
    WeightCommand() {
        super("weight", "weight <source> <target>", "show the weight of edge");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        System.out.println(graph.getWeight(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1))));
    }
}
