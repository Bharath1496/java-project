package com.WithDatabase.FlowchartDb.Controller;

import com.WithDatabase.FlowchartDb.Entity.Edge;
import com.WithDatabase.FlowchartDb.Entity.FlowChart;
import com.WithDatabase.FlowchartDb.Entity.Node;
import com.WithDatabase.FlowchartDb.Service.FlowChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flowcharts")
public class FlowChartController {

    private final FlowChartService flowChartService;

    @Autowired
    public FlowChartController(FlowChartService flowChartService) {
        this.flowChartService = flowChartService;
    }

    // 1. Create Flowchart
    @PostMapping
    public FlowChart createFlowchart(@RequestBody FlowChart flowChart) {
        return flowChartService.createFlowchart(flowChart);
    }

    // 2. Get Flowchart by ID
    @GetMapping("/{id}")
    public FlowChart getFlowchartById(@PathVariable String id) {
        return flowChartService.getFlowchartById(id);
    }

    // 3. Delete Flowchart by ID
    @DeleteMapping("/{id}")
    public void deleteFlowchartById(@PathVariable String id) {
        flowChartService.deleteFlowchartById(id);
    }

    // 4. Add Node to Flowchart
    @PostMapping("/{id}/nodes")
    public void addNodeToFlowchart(@PathVariable String id, @RequestBody Node node) {
        flowChartService.addNodeToFlowchart(id, node);
    }

    // 5. Remove Node from Flowchart
    @DeleteMapping("/{id}/nodes/{nodeId}")
    public void removeNodeFromFlowchart(@PathVariable String id, @PathVariable String nodeId) {
        flowChartService.removeNodeFromFlowchart(id, nodeId);
    }

    // 6. Add Edge to Flowchart
    @PostMapping("/{id}/edges")
    public void addEdgeToFlowchart(@PathVariable String id, @RequestBody Edge edge) {
        flowChartService.addEdgeToFlowchart(id, edge);
    }

    // 7. Remove Edge from Flowchart
    @DeleteMapping("/{id}/edges/remove/{from}/{to}")
    public void removeEdgeFromFlowchart(@PathVariable String id, @PathVariable String from, @PathVariable String to) {
        flowChartService.removeEdgeFromFlowchart(id, from, to);
    }
}

