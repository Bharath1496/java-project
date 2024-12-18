package com.WithDatabase.FlowchartDb.DAO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.WithDatabase.FlowchartDb.Entity.Edge;
import com.WithDatabase.FlowchartDb.Entity.FlowChart;
import com.WithDatabase.FlowchartDb.Entity.Node;

@Repository
public class FlowChartDAOImpl implements FlowChartDAO {

  
    private EntityManager entityManager;
    
    @Autowired
    public FlowChartDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Override
//    public FlowChart save(FlowChart flowChart) {
//        entityManager.persist(flowChart);
//        return flowChart;
//    }
    
    @Override
    public FlowChart createFlowchart(FlowChart flowChart) {
        for (Edge edge : flowChart.getEdges()) {
            // Ensure both fromNode and toNode exist in the database
            if (edge.getFromNode() != null && edge.getToNode() != null) {
                // Make sure the nodes are already saved
                entityManager.merge(edge.getFromNode()); // Save fromNode
                entityManager.merge(edge.getToNode());   // Save toNode
            } else {
                throw new IllegalArgumentException("Both fromNode and toNode must be set and persisted.");
            }
        }
        return entityManager.merge(flowChart); // Save the flowchart with properly linked nodes and edges
    }


    @Override
    public FlowChart findById(String flowchartId) {
//        return entityManager.find(FlowChart.class, flowchartId);
    	FlowChart flowChart = entityManager.find(FlowChart.class, flowchartId);
        if (flowChart != null) {
            // Load associated nodes and edges if not already initialized
            if (flowChart.getNodes() != null) {
                for (Node node : flowChart.getNodes()) {
                    // Lazy loading of outgoingEdges and incomingEdges if not fetched
                    if (node.getOutgoingEdges() != null) {
                        node.getOutgoingEdges().size();  // Initialize lazy collection
                    }
                    if (node.getIncomingEdges() != null) {
                        node.getIncomingEdges().size();  // Initialize lazy collection
                    }
                }
            }
            if (flowChart.getEdges() != null) {
                for (Edge edge : flowChart.getEdges()) {
                    // Ensure all Edge relationships are loaded
                    if (edge.getFromNode() != null) {
                        edge.getFromNode().getNodeId();  // Initialize lazy fetch if necessary
                    }
                    if (edge.getToNode() != null) {
                        edge.getToNode().getNodeId();  // Initialize lazy fetch if necessary
                    }
                }
            }
        }
        return flowChart;
    }

    @Override
    public void deleteById(String flowchartId) {
        FlowChart flowChart = entityManager.find(FlowChart.class, flowchartId);
        entityManager.remove(flowChart);
    }
    
    @Override
    public void addNodeToFlowChart(String flowchartId, Node node) {
        FlowChart flowChart = findById(flowchartId);
        if (!flowChart.getNodes().contains(node)) {
            flowChart.getNodes().add(node);
            entityManager.merge(flowChart);
        }
    }
    
    @Override
    public void removeNodeFromFlowChart(String flowchartId, String nodeId) {
        FlowChart flowChart = findById(flowchartId);
        flowChart.getNodes().removeIf(node -> node.getNodeId().equals(nodeId));
        entityManager.merge(flowChart);
    }
    
    @Override
    public void addEdgeToFlowChart(String flowchartId, Edge edge) {
        FlowChart flowChart = findById(flowchartId);
        if (!flowChart.getEdges().contains(edge)) {
            flowChart.getEdges().add(edge);
            entityManager.merge(flowChart);
        }
    }
    
    @Override
    public void removeEdgeFromFlowChart(String flowchartId, String from, String to) {
        FlowChart flowChart = findById(flowchartId);
        flowChart.getEdges().removeIf(edge -> edge.getFromNode().equals(from) && edge.getToNode().equals(to));
        entityManager.merge(flowChart);
    }

}
