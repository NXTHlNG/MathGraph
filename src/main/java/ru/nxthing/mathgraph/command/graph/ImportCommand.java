package ru.nxthing.mathgraph.command.graph;

import org.jgrapht.nio.csv.CSVFormat;
import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class ImportCommand extends AbstractCommand implements GraphCommand {
    ImportCommand() {
        super("import", "import <format> <?path>", "import graph from a file");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        CSVFormat format = switch (parameters.get(0).toLowerCase()) {
            case "matrix" -> CSVFormat.MATRIX;
            case "list" -> CSVFormat.ADJACENCY_LIST;
            default -> throw new IllegalStateException("Unexpected value: " + parameters.get(0));
        };

        if (parameters.size() == 1) {
            graph.importGraph(format);
        } else if (parameters.size() == 2) {
            graph.importGraph(format, parameters.get(1));
        }


    }
}
