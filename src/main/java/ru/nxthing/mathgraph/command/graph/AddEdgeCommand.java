package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class AddEdgeCommand extends AbstractCommand implements GraphCommand {
    AddEdgeCommand() {
        super("add-edge", "add-edge <source> <target> <?weight>", "add an edge to the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        if (parameters.size() == 2) {
            graph.addEdge(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)));
        } else if (parameters.size() == 3) {
            graph.addEdge(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)), Double.parseDouble(parameters.get(2)));
        }
    }
}
