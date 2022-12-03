package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class DeleteEdgeCommand extends AbstractCommand implements GraphCommand {
    DeleteEdgeCommand() {
        super("delete-edge", "delete-edge <source> <target>", "delete an edge from the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        graph.deleteEdge(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1)));
    }
}
