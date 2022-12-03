package ru.nxthing.mathgraph.command.graph;

import ru.nxthing.mathgraph.command.Command;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

public interface GraphCommand extends Command {
    void execute(MathGraph graph, List<String> parameters);
}
