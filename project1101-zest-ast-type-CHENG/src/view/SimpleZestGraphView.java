/*
 * @(#) View.java
 *
 */
package view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.RadialLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import data.DataNode;
import graph.builder.GModelBuilder;
import graph.provider.GLabelProvider;
import graph.provider.GNodeContentProvider;

public class SimpleZestGraphView {
	public static final String SIMPLEZESTVIEW = "simplezestproject4.partdescriptor.simplezestview4";
	public static final String POPUPMENU_ID = "simplezestproject4.popupmenu.mypopupmenu";
	private GraphViewer gViewer;
	private int layout = 0;

	private Graph graph;
	private Map<String, GraphNode> graphNodeMap = new HashMap<String, GraphNode>();

	@PostConstruct
	public void createControls(Composite parent, EMenuService menuService) {
		gViewer = new GraphViewer(parent, SWT.BORDER);
		gViewer.setContentProvider(new GNodeContentProvider());
		gViewer.setLabelProvider(new GLabelProvider());
		gViewer.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		gViewer.applyLayout();
		menuService.registerContextMenu(gViewer.getControl(), POPUPMENU_ID);
	}

	public void update() {
		gViewer.setInput(GModelBuilder.instance().getNodes());
		if (layout % 2 == 0)
			gViewer.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		else
			gViewer.setLayoutAlgorithm(new RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
		layout++;
	}

	private GraphNode createGraphNode(DataNode dataNode) {
		GraphNode graphNode = graphNodeMap.get(dataNode.getNodeName());
		if (graphNode == null) {
			graphNode = new GraphNode(this.graph, SWT.NONE, dataNode.getNodeName());
			graphNodeMap.put(dataNode.getNodeName(), graphNode);
		}
		return graphNode;
	}

	public void updateByContextMenu(List<DataNode> nodeList) {
		clear();
		for (DataNode iNode : nodeList) {
			GraphNode iGraphNode = createGraphNode(iNode); // create a new one or reuse if it exists already.
			List<DataNode> childNodeList = iNode.getChildNodes();

			for (DataNode jChildNode : childNodeList) {
				GraphNode jChildGraphNode = createGraphNode(jChildNode);
				createConnection(iGraphNode, jChildGraphNode);
				// TODO: Class Exercise
				checkEmptyNode(jChildNode, jChildGraphNode);
			}
		}
		graph.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
	}

	private void checkEmptyNode(DataNode dataNode, GraphNode graphNode) {
		// TODO: Class Exercise
		if (dataNode.isEmptyBody()) {
			graphNode.setBackgroundColor(ColorConstants.red);
			graphNode.setForegroundColor(ColorConstants.yellow);
		}
	}

	private void clear() {
		for (Entry<String, GraphNode> entry : graphNodeMap.entrySet()) {
			GraphNode iNode = entry.getValue();
			iNode.dispose();
		}
		graphNodeMap.clear();
	}

	private void createConnection(GraphNode srcGNode, GraphNode dstGNode) {
		new GraphConnection(graph, ZestStyles.CONNECTIONS_SOLID, srcGNode, dstGNode);
	}

	@Focus
	public void setFocus() {
		this.gViewer.getGraphControl().setFocus();
	}
}
