package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class IsAdjacentCommand extends AbstractCommand implements GraphCommand {
    IsAdjacentCommand() {
        super("is-adjacent", "is-adjacent <vertex1> <vertex2>", "show whether vertices are adjacent");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        System.out.println(graph.isAdjacent(Integer.parseInt(parameters.get(0)), Integer.parseInt(parameters.get(1))));
    }
}
