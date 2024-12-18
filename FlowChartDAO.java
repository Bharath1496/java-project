package com.WithDatabase.FlowchartDb.DAO;

import com.WithDatabase.FlowchartDb.Entity.Edge;
import com.WithDatabase.FlowchartDb.Entity.FlowChart;
import com.WithDatabase.FlowchartDb.Entity.Node;

public interface FlowChartDAO {
//	    FlowChart save(FlowChart flowChart);               // Create Flowchart
	    FlowChart createFlowchart(FlowChart flowChart);
	    FlowChart findById(String flowchartId);             // Fetch Flowchart by ID
//	    FlowChart updateFlowchart(FlowChart flowChart);     // Update Flowchart
	    void deleteById(String flowchartId);                // Delete Flowchart by ID
	    
//	    Optional<FlowChart> findById(String flowchartId);
	    
	    void addNodeToFlowChart(String flowchartId, Node node);

	    void removeNodeFromFlowChart(String flowchartId, String nodeId);

	    void addEdgeToFlowChart(String flowchartId, Edge edge);

	    void removeEdgeFromFlowChart(String flowchartId, String from, String to);
	    
}


