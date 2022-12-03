package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class EdgeNumberCommand extends AbstractCommand implements GraphCommand {
    EdgeNumberCommand() {
        super("edge-number", "edge-number", "show the number of edges on the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        System.out.println(graph.getEdgeNumber());
    }
}
