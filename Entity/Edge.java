package com.WithDatabase.FlowchartDb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "edges")
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented edge ID
    private Long edgeId;

    @ManyToOne
    @JoinColumn(name = "from_node_id", nullable = false) // Foreign key to source node
    private Node fromNode;

    @ManyToOne
    @JoinColumn(name = "to_node_id", nullable = false) // Foreign key to target node
    private Node toNode;

    public Edge() {
        // Default constructor for JPA
    }

//    public Edge(Node fromNode, Node toNode) {
//        this.fromNode = fromNode;
//        this.toNode = toNode;
//    }
    
    public Edge(Node fromNode, Node toNode) {
        if (fromNode != null && toNode != null) {
            this.fromNode = fromNode; // already persisted node
            this.toNode = toNode;     // already persisted node
        } else {
            throw new IllegalArgumentException("Both fromNode and toNode must be set and already persisted.");
        }
    }


    // Getters and setters
    public Long getEdgeId() {
        return edgeId;
    }

    public void setEdgeId(Long edgeId) {
        this.edgeId = edgeId;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public void setFromNode(Node fromNode) {
        this.fromNode = fromNode;
    }

    public Node getToNode() {
        return toNode;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "edgeId=" + edgeId +
                ", fromNode=" + (fromNode != null ? fromNode.getNodeId() : null) +
                ", toNode=" + (toNode != null ? toNode.getNodeId() : null) +
                '}';
    }
}
