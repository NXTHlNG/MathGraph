package ru.nxthing.mathgraph.graph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.nio.csv.CSVExporter;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.nio.csv.CSVImporter;
import org.jgrapht.util.SupplierUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;


@Component
public class MathGraph {
    private Graph<Integer, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(SupplierUtil.createIntegerSupplier(), SupplierUtil.createDefaultWeightedEdgeSupplier());

    public void importGraph(CSVFormat format, String path) {
        clearGraph();
        CSVImporter<Integer, DefaultWeightedEdge> csvImporter = new CSVImporter<>(format);

        csvImporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_ZERO_WHEN_NO_EDGE, true);
        csvImporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_NODEID, true);
        csvImporter.setParameter(CSVFormat.Parameter.EDGE_WEIGHTS, true);
        csvImporter.setVertexFactory(Integer::parseInt);

        csvImporter.importGraph(graph, new File(path));
    }

    public void importGraph(CSVFormat format) {
        importGraph(format, "src/main/resources/graph.txt");
    }

    public void exportGraph(CSVFormat format, String path) {
        CSVExporter<Integer, DefaultWeightedEdge> csvExporter = new CSVExporter<>(format);

        csvExporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_ZERO_WHEN_NO_EDGE, true);
        csvExporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_NODEID, true);
        csvExporter.setParameter(CSVFormat.Parameter.EDGE_WEIGHTS, true);
        csvExporter.setVertexIdProvider(Object::toString);

        csvExporter.exportGraph(graph, new File(path));
    }

    public void exportGraph(CSVFormat format) {
        exportGraph(format, "src/main/resources/graph.txt");
    }

    public boolean addVertex(int v) {
        return graph.addVertex(v);
    }

    public boolean deleteVertex(int v) {
        return graph.removeVertex(v);
    }

    public DefaultWeightedEdge addEdge(int v1, int v2) {
        return graph.addEdge(v1, v2);
    }

    public DefaultWeightedEdge addEdge(int v1, int v2, double weight) {
        DefaultWeightedEdge edge = graph.addEdge(v1, v2);
        graph.setEdgeWeight(edge, weight);
        return edge;
    }

    public DefaultWeightedEdge deleteEdge(int v1, int v2) {
        return graph.removeEdge(v1, v2);
    }

    public void setEdgeWeight(int v1, int v2, double weight) {
        graph.setEdgeWeight(v1, v2, weight);
    }

    public int getVertexNumber() {
        return graph.vertexSet().size();
    }

    public int getEdgeNumber() {
        return graph.edgeSet().size();
    }

    public boolean isAdjacent(int v1, int v2) {
        return graph.getAllEdges(v1, v2).size() > 0;
    }

    public double getWeight(int v1, int v2) {
        return graph.getEdgeWeight(graph.getEdge(v1, v2));
    }

    public Set<Integer> getVertices() {
        return graph.vertexSet();
    }

    public Set<DefaultWeightedEdge> getEdges() {
        return graph.edgeSet();
    }

    public void visualize() {

    }

    public void print() {
        CSVExporter<Integer, DefaultWeightedEdge> csvExporter = new CSVExporter<>(CSVFormat.MATRIX);
        csvExporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_ZERO_WHEN_NO_EDGE, true);
        csvExporter.setParameter(CSVFormat.Parameter.MATRIX_FORMAT_NODEID, true);
        csvExporter.setParameter(CSVFormat.Parameter.EDGE_WEIGHTS, true);
        csvExporter.setVertexIdProvider(Object::toString);
        Writer writer = new StringWriter();
        csvExporter.exportGraph(graph, writer);

        String[] strings = (" " + writer).replace("\n", "").replace("\r", "").split(",");
        int a = (int) Math.sqrt(strings.length) + 1;

        ("0" + writer).lines().forEach(s -> {
            String[] split = s.split(",");
            System.out.format("|" + "%5s|".repeat(split.length) + "%n" + "+" + "_____+".repeat(split.length) + "%n", split);
        });
    }

    private void clearGraph() {
        graph = new DefaultDirectedWeightedGraph<>(SupplierUtil.createIntegerSupplier(), SupplierUtil.createDefaultWeightedEdgeSupplier());
    }
}
