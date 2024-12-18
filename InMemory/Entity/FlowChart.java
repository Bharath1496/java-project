package com.Inmemory.Flowchart.Entity;

import java.util.ArrayList;
import java.util.List;

public class FlowChart {
    private String id;                // Unique identifier for the flowchart
    private List<Node> nodes;         // List of nodes
    private List<Edge> edges;         // List of edges

    public FlowChart(String id) {
        this.id = id;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public FlowChart() {} // Default constructor for deserialization

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
  

    public void addNode(Node node) {
        nodes.add(node);
    }
    

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
    

    public void removeNode(String nodeId) {
        nodes.removeIf(node -> node.getId().equals(nodeId));
        edges.removeIf(edge -> edge.getFrom().equals(nodeId) || edge.getTo().equals(nodeId));
    }

    public void removeEdge(String from, String to) {
        edges.removeIf(edge -> edge.getFrom().equals(from) && edge.getTo().equals(to));
    }

    @Override
    public String toString() {
        return "Flowchart{id='" + id + "', nodes=" + nodes + ", edges=" + edges + "}";
    }
}
