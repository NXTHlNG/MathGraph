package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class AddVerticesCommand extends AbstractCommand implements GraphCommand {
    AddVerticesCommand() {
        super("add-vertices", "add-vertices [<vertex1> <vertex2> <vertex3> ...]", "add multiple vertices to the graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        graph.addVertices(parameters.stream()
                .map(Integer::parseInt)
                .toList());
    }
}
