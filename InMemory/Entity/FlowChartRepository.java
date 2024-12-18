package com.Inmemory.Flowchart.Entity;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FlowChartRepository {
    private final Map<String, FlowChart> flowcharts = new HashMap<>();

    public FlowChart createFlowchart(String id) {
        FlowChart flowchart = new FlowChart(id);
        flowcharts.put(id, flowchart);
        return flowchart;
    }

    public FlowChart getFlowchart(String id) {
        return flowcharts.get(id);
    }

    public void deleteFlowchart(String id) {
        flowcharts.remove(id);
    }
    
    // Save a flowchart
    public void saveFlowchart(FlowChart flowChart) {
        flowcharts.put(flowChart.getId(), flowChart);
    }
    
    public void removeEdgeFromFlowChart(String flowchartId, String from, String to) {
        FlowChart flowChart = findById(flowchartId);
        if (flowChart != null) {
            flowChart.removeEdge(from, to); // Remove the edge from the flowchart using from and to identifiers
            saveFlowchart(flowChart); // Save the updated flowchart
        }
    }
    
    public FlowChart findById(String id) {
        return flowcharts.get(id);
    }
    
    // Save or update a flowchart
    public void updateFlowchart(FlowChart flowChart) {
        flowcharts.put(flowChart.getId(), flowChart);
    }

    public Map<String, FlowChart> getAllFlowCharts() {
        return flowcharts;
    }
}
