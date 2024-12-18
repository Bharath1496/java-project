package com.WithDatabase.FlowchartDb.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "flowcharts")
public class FlowChart {

    @Id
    @Column(name = "flowchart_id", nullable = false, unique = true)
    private String id; // Unique identifier for the flowchart

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "flowchart_id") // Foreign key in the nodes table
    private List<Node> nodes; // List of nodes in the flowchart

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "flowchart_id") // Foreign key in the edges table
    private List<Edge> edges; // List of edges in the flowchart

    public FlowChart() {
        // Default constructor for JPA
    }

    public FlowChart(String id) {
        this.id = id;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "FlowChart{" +
                "id='" + id + '\'' +
                ", nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}

