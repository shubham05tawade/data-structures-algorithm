import java.util.*;

class Graph{
	
	//Create adjacency list graph
	private HashMap<String, ArrayList<String>> adjList = new HashMap<String, ArrayList<String>>();
	
	//Add Vertex
	public boolean addVertex(String vertex){
		if(adjList.get(vertex) == null){
			adjList.put(vertex, new ArrayList<String>());
			return true;
		}
		return false;
	}
	
	//Add edge
	public boolean addEdge(String vertex1, String vertex2){
		if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
			adjList.get(vertex1).add(vertex2);
			adjList.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}
	
	//print graph
	public void printGraph(){
		System.out.println(adjList);
	}
	
}

public class GraphMain{
	public static void main(String args[]){
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addEdge("A", "B");
		graph.printGraph();
	}
}