package com.WithDatabase.FlowchartDb.Service;

import com.WithDatabase.FlowchartDb.DAO.FlowChartDAO;
import com.WithDatabase.FlowchartDb.Entity.Edge;
import com.WithDatabase.FlowchartDb.Entity.FlowChart;
import com.WithDatabase.FlowchartDb.Entity.Node;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowChartServiceImpl implements FlowChartService{
	
	 private final FlowChartDAO flowChartDAO;

	    @Autowired
	    public FlowChartServiceImpl(FlowChartDAO flowChartDAO) {
	        this.flowChartDAO = flowChartDAO;
	    }

	    @Override
	    @Transactional
	    public FlowChart createFlowchart(FlowChart flowChart) {
	        return flowChartDAO.createFlowchart(flowChart);
	    }

	    @Override
	    public FlowChart getFlowchartById(String flowchartId) {
	        return flowChartDAO.findById(flowchartId);
	    }

	    @Override
	    @Transactional
	    public void deleteFlowchartById(String flowchartId) {
	        flowChartDAO.deleteById(flowchartId);
	    }

	    @Override
	    @Transactional
	    public void addNodeToFlowchart(String flowchartId, Node node) {
	        flowChartDAO.addNodeToFlowChart(flowchartId, node);
	    }

	    @Override
	    @Transactional
	    public void removeNodeFromFlowchart(String flowchartId, String nodeId) {
	        flowChartDAO.removeNodeFromFlowChart(flowchartId, nodeId);
	    }

	    @Override
	    @Transactional
	    public void addEdgeToFlowchart(String flowchartId, Edge edge) {
	        flowChartDAO.addEdgeToFlowChart(flowchartId, edge);
	    }

	    @Override
	    @Transactional
	    public void removeEdgeFromFlowchart(String flowchartId, String from, String to) {
	        flowChartDAO.removeEdgeFromFlowChart(flowchartId, from, to);
	    }
	
}
