package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class AddVertexCommand extends AbstractCommand implements GraphCommand {
    AddVertexCommand() {
        super("add-vertex", "add-vertex <vertex>", "add a vertex to the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        graph.addVertex(Integer.parseInt(parameters.get(0)));
    }
}
