package com.WithDatabase.FlowchartDb.Service;
import com.WithDatabase.FlowchartDb.Entity.Edge;
import com.WithDatabase.FlowchartDb.Entity.FlowChart;
import com.WithDatabase.FlowchartDb.Entity.Node;

public interface FlowChartService {

	    FlowChart createFlowchart(FlowChart flowChart);

	    FlowChart getFlowchartById(String flowchartId);

	    void deleteFlowchartById(String flowchartId);

	    void addNodeToFlowchart(String flowchartId, Node node);

	    void removeNodeFromFlowchart(String flowchartId, String nodeId);

	    void addEdgeToFlowchart(String flowchartId, Edge edge);

	    void removeEdgeFromFlowchart(String flowchartId, String from, String to);

}