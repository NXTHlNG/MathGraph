package ru.nxthing.mathgraph.command.graph;

import org.jgrapht.nio.csv.CSVFormat;
import org.springframework.stereotype.Component;
import ru.nxthing.mathgraph.command.AbstractCommand;
import ru.nxthing.mathgraph.graph.MathGraph;

import java.util.List;

@Component
public class ExportCommand extends AbstractCommand implements GraphCommand {
    ExportCommand() {
        super("export", "export <format> <?path>", "export graph to a file with two formats: matrix, list");
    }

    @Override
    public void execute(MathGraph graph, List<String> parameters) {
        CSVFormat format = switch (parameters.get(0).toLowerCase()) {
            case "matrix" -> CSVFormat.MATRIX;
            case "list" -> CSVFormat.ADJACENCY_LIST;
            default ->
                    throw new RuntimeException("Invalid export format: " + parameters.get(0) + " available formats: matrix, list");
        };


        if (parameters.size() == 1) {
            graph.exportGraph(format);
        } else {
            graph.exportGraph(format, parameters.get(1));
        }

    }
}
