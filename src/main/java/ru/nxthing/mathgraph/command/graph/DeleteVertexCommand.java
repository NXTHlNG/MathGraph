package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class DeleteVertexCommand extends AbstractCommand implements GraphCommand {
    DeleteVertexCommand() {
        super("delete-vertex", "delete-vertex <vertex>", "delete a vertex from the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        graph.deleteVertex(Integer.parseInt(parameters.get(0)));
    }
}
