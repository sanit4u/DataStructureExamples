package advance.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstraAlgorithm {

	public static class Node {

		private String name;

		private Integer distance = Integer.MAX_VALUE;

		private List<Node> shortestPath = new LinkedList<Node>();

		Map<Node, Integer> adjacentNodes = new HashMap<>();

		public void addDestination(Node destination, int distance) {
			adjacentNodes.put(destination, distance);
		}

		public Node(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(Integer distance) {
			this.distance = distance;
		}

		public List<Node> getShortestPath() {
			return shortestPath;
		}

		public void setShortestPath(List<Node> shortestPath) {
			this.shortestPath = shortestPath;
		}

		public Map<Node, Integer> getAdjacentNodes() {
			return adjacentNodes;
		}

	}

	public static class Graph {
		private Set<Node> nodes = new HashSet<>();

		public void addNode(Node nodeA) {
			nodes.add(nodeA);
		}

	}

	//@formatter:off
	/**
	 *  The Idea is: 
	 *  
	 *  1. Dijkstra's Algorithm is also known as Single Source Shortest Path Algorithm.
	 *  2. Hence, from the source, we need to calculate the other nodes distance.
	 *  3. In order to do that, we have to set the distance of other nodes to maximum and the source's distance to 0,
	 *  4. and we need to keep track of all the processed node and don't process them again. So a settled node[Sset] and unsettled node set[USet] will be helpful for that.
	 *  5. first , we need to check which unsettled node is having the minimum distance. and choose that node. Let say that node is X
	 *  6. after choosing, the node with minimum distance (X), remove it from unsettled node and go through it's adjacent Nodes and their corresponding weight.
	 *  7. go through only those adjacent Nodes, those are not been settled yet. i.e; does not belong to the settled node set. [Sset]
	 *  8. calculate the distance from the earlier chosen minimum Node (X) to the adjacent nodes on by one. and update the distance of the adjacent node.
	 *  	// By if ((distance of X +edge weight of X to the current adjacent Node) > the distance of the adjacent Node) -> then update the distance of the adjacent Node.
	 *      // add the adjacent node to the unsettled node set[Uset]. because, later we need to check the distance from this node to it's adjacent Nodes(if any).  
	 *      // Do the above step for all the adjacent nodes w.r.t X. 
	 *  9. then remove the X from the unsettled Node[USet]. Because,till this point this node (X) is settled; hence, add it to the settled graph. 
	 * 10. repeat the process from step 5 till 9. for that have a while loop and process that until the unsettlednodeset[USet] is empty.
	 * 11. Now, every node is relaxed and their shortest distance is calculated from the source node.
	 * 
	 * 
	 * The Time Complexity of this algorithm is O (N*N). Since, in the case of a complete graph, it every node is connected to every other node (N), 
	 * then it has to go through every node, and it's every adjacent Node(N). Hence, the complexity will be N*N. 
	 * 
	 * @param graph
	 * @param source
	 * @return
	 */
	//@formatter:off
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

		// from source to source distance is 0
		source.setDistance(0);

		Set<Node> setteledGraph = new HashSet<Node>();
		Set<Node> unSetteledGraph = new HashSet<Node>();

		unSetteledGraph.add(source);

		while (!unSetteledGraph.isEmpty()) {
			Node currentNode = getLowestDistanceNode(unSetteledGraph);

			for (Entry<Node, Integer> adjacentNodes : currentNode.getAdjacentNodes().entrySet()) {
				Node node = adjacentNodes.getKey();
				Integer edgeWeight = adjacentNodes.getValue();

				if (!setteledGraph.contains(node)) {
					calculateMinimumDistanceFromCurrentNode(node, edgeWeight, currentNode);

					unSetteledGraph.add(node);
				}

			}
			unSetteledGraph.remove(currentNode);
			setteledGraph.add(currentNode);
		}

		return graph;

	}

	private static void calculateMinimumDistanceFromCurrentNode(Node node, Integer edgeWeight, Node currentNode) {
		int calculatedDistance = currentNode.getDistance() + edgeWeight;
		if (calculatedDistance < node.getDistance()) {

			node.setDistance(calculatedDistance);
			List<Node> shortestPath = new LinkedList<Node>(currentNode.getShortestPath());
			shortestPath.add(currentNode);
			node.setShortestPath(shortestPath);
		}
	}

	private static Node getLowestDistanceNode(Set<Node> unSetteledGraph) {

		int minDistance = Integer.MAX_VALUE;

		Node minDistanceNode = null;

		for (Node node : unSetteledGraph) {

			if (node.getDistance() < minDistance) {
				minDistanceNode = node;
				minDistance = node.getDistance();
			}

		}

		return minDistanceNode;
	}

	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);

		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);

		nodeC.addDestination(nodeE, 10);

		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);

		nodeF.addDestination(nodeE, 5);

		Graph graph = new Graph();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

		graph = calculateShortestPathFromSource(graph, nodeA);

		List<Node> shortestPath = nodeD.getShortestPath();

		for (Node node : shortestPath) {
			System.out.println(node.name);
		}

	}

}
