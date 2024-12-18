package com.Inmemory.Flowchart.Entity;


public class Edge {
    private String from;  // Source node ID
    private String to;    // Target node ID

    public Edge(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public Edge() {} // Default constructor for deserialization

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge{from='" + from + "', to='" + to + "'}";
    }
}

