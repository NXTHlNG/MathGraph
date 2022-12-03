package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class VertexNumberCommand extends AbstractCommand implements GraphCommand {
    VertexNumberCommand() {
        super("vertex-number", "vertex-number", "show the number of vertices on the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        System.out.println(graph.getVertexNumber());
    }
}
