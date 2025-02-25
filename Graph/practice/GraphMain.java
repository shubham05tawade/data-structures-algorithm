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
	
	//remove edge
	public boolean removeEdge(String vertex1, String vertex2){
		if(adjList.get(vertex1) != null && adjList.get(vertex2) != null){
			adjList.get(vertex1).remove(vertex2);
			adjList.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}
	
	//remove vertex
	public boolean removeVertex(String vertex){
		//check if vertex exist
		if(adjList.get(vertex) != null){
			//Remove all the edge from vertices that connects to vertex
			for(String adjVertex: adjList.get(vertex)){
				adjList.get(adjVertex).remove(vertex);
			}
			//Remove vertex
			adjList.remove(vertex);
			return true;
		}
		return false;
	}
}

public class GraphMain{
	public static void main(String args[]){
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B");
		graph.addEdge("C", "B");
		graph.addEdge("C", "D");
		graph.addEdge("D", "A");
		graph.removeEdge("C", "D");
		graph.removeVertex("A");
		graph.printGraph();
	}
}