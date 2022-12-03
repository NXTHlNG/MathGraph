package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class VerticesCommand extends AbstractCommand implements GraphCommand {
    VerticesCommand() {
        super("vertices", "vertices", "show the vertices");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        System.out.println(graph.getVertices());
    }
}
