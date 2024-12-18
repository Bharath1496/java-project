package com.Inmemory.Flowchart.Controller;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Inmemory.Flowchart.Entity.Edge;
import com.Inmemory.Flowchart.Entity.FlowChart;
import com.Inmemory.Flowchart.Entity.Node;
import com.Inmemory.Flowchart.Service.FlowChartService;
import java.util.Map;

@RestController
@RequestMapping("/api/flowcharts")
	public class FlowChartController {
	    private final FlowChartService service;

	    @Autowired
	    public FlowChartController(FlowChartService service) {
	        this.service = service;
	    }

	    // Create a new flowchart
	    @PostMapping
	    public FlowChart createFlowchart(@RequestParam String id) {
	        return service.createFlowchart(id);
	    }
	    
	    // Get a flowchart by ID
	    @GetMapping("/{id}")
	    public FlowChart getFlowchart(@PathVariable String id) {
	        return service.getFlowchart(id);
	    }

	    // Delete a flowchart by ID
	    @DeleteMapping("/{id}")
	    public String deleteFlowchart(@PathVariable String id) {
	        service.deleteFlowchart(id);
	        return "Flowchart with ID " + id + " deleted.";
	    }

	    // Get all flowcharts
	    @GetMapping
	    public Map<String, FlowChart> getAllFlowcharts() {
	        return service.getAllFlowCharts();
	    }
	    
	    // Add a node to a flowchart
	    @PostMapping("/{id}/nodes")
	    public FlowChart addNode(@PathVariable String id, @RequestBody Node node) {
	        return service.addNode(id, node);
	    }

	    // Add an edge to a flowchart
	    @PostMapping("/{id}/edges")
	    public FlowChart addEdge(@PathVariable String id, @RequestBody Edge edge) {
	        return service.addEdge(id, edge);
	    }
	    
	    // Remove an edge in a flowchart
	    @DeleteMapping("/{id}/edges/remove/{from}/{to}")
	    public FlowChart removeEdge(@PathVariable String id,@PathVariable String from, @PathVariable String to) {
	    	 Edge edge = new Edge(from, to); // Create edge using from and to
	    	 return service.removeEdge(id, edge);
	    }
	    	        
	    // Remove a node from a flowchart
	    @DeleteMapping("/{id}/nodes/remove/{nodeId}")
	    public FlowChart removeNode(@PathVariable String id, @PathVariable  String nodeId) {
	        return service.removeNode(id, nodeId);
	    }

	   
	}


