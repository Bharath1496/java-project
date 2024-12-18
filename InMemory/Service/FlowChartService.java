package com.Inmemory.Flowchart.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inmemory.Flowchart.Entity.Edge;
import com.Inmemory.Flowchart.Entity.FlowChart;
import com.Inmemory.Flowchart.Entity.FlowChartRepository;
import com.Inmemory.Flowchart.Entity.Node;

@Service
public class FlowChartService {
	private final FlowChartRepository repository;

    @Autowired
    public FlowChartService(FlowChartRepository repository) {
        this.repository = repository;
    }

    // Create a new flowchart
    public FlowChart createFlowchart(String id) {
        return repository.createFlowchart(id);
        
    }

    // Get a flowchart by ID
    public FlowChart getFlowchart(String id) {
        FlowChart flowchart = repository.getFlowchart(id);
        if (flowchart == null) {
            throw new IllegalArgumentException("Flowchart with ID " + id + " not found.");
        }
        return flowchart;
    }

    // Add a node to a flowchart
    public FlowChart addNode(String flowchartId, Node node) {
        FlowChart flowchart = getFlowchart(flowchartId);
        flowchart.addNode(node);
        return flowchart;
    }
    
    public FlowChart removeNode(String flowchartId, String nodeId) {
        FlowChart flowchart = getFlowchart(flowchartId);       
        flowchart.removeNode(nodeId); // Remove the node
        return flowchart;
    }

    // Add an edge to a flowchart
    public FlowChart addEdge(String flowchartId, Edge edge) {
        FlowChart flowchart = getFlowchart(flowchartId);
        flowchart.addEdge(edge);
        return flowchart;
    }
    
    public FlowChart removeEdge(String flowchartId, Edge edge) {
        FlowChart flowChart = getFlowchart(flowchartId);
        if (flowChart != null) {
            repository.removeEdgeFromFlowChart(flowchartId, edge.getFrom(), edge.getTo()); // Use the new method to remove edge by identifiers
            return flowChart; // Return the updated flowchart
        }
        return null; // Return null if the flowchart was not found
    }

    // Delete a flowchart by ID
    public void deleteFlowchart(String id) {
        if (repository.getFlowchart(id) == null) {
            throw new IllegalArgumentException("Flowchart with ID " + id + " does not exist.");
        }
        repository.deleteFlowchart(id);
    }
    

    // Get all flowcharts
    public Map<String, FlowChart> getAllFlowCharts() {
        return repository.getAllFlowCharts();
    }
}