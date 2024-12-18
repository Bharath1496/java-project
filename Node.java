package com.WithDatabase.FlowchartDb.Entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "nodes")
public class Node {

    @Id
    @Column(name = "node_id", nullable = false, unique = true)
    private String nodeId; // Unique ID for each node

    @OneToMany(mappedBy = "fromNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edge> outgoingEdges; // Edges originating from this node

    @OneToMany(mappedBy = "toNode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edge> incomingEdges; // Edges pointing to this node

    public Node() {
        // Default constructor for JPA
    }

    public Node(String nodeId) {
        this.nodeId = nodeId;
    }

    // Getters and Setters
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public List<Edge> getOutgoingEdges() {
        return outgoingEdges;
    }

    public void setOutgoingEdges(List<Edge> outgoingEdges) {
        this.outgoingEdges = outgoingEdges;
    }

    public List<Edge> getIncomingEdges() {
        return incomingEdges;
    }

    public void setIncomingEdges(List<Edge> incomingEdges) {
        this.incomingEdges = incomingEdges;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId='" + nodeId + '\'' +
                '}';
    }
}