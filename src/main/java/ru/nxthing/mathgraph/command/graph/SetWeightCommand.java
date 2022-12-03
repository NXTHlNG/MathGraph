package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class SetWeightCommand extends AbstractCommand implements GraphCommand {
    public SetWeightCommand() {
        super("set-weight", "set-weight <source> <target> <weight>", "set a weight to an edge");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        graph.setEdgeWeight(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)), Double.parseDouble(parameters.get(2)));
    }
}
