package ru.nxthing.mathgraph.command.graph;

import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class PrintCommand extends AbstractCommand implements GraphCommand {
    public PrintCommand() {
        super("print", "print", "print graph");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        graph.print();
    }
}
