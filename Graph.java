import java.util.ArrayList;
import java.util.HashMap;
public class Graph {
	private static HashMap<Integer, Vertex> verticies;

	public Graph(HashMap<Integer, Vertex> verticies) {
		this.verticies = verticies;
	}
	public boolean isConnected() {
		HashMap<Vertex, Boolean> graph = new HashMap<Vertex, Boolean>();
		Vertex v1 = null;
		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			graph.put(vertex, false);
			v1 = vertex;
		}
		graph = explore(v1, graph);
		for(Vertex v : graph.keySet()) {
			if(!graph.get(v)) {
				return false;
			}
		}
		return true;
	}

	public static HashMap<Vertex, Boolean> explore (Vertex v, HashMap<Vertex, Boolean> graph) {
		graph.remove(v);
		graph.put(v, true);
		for(Vertex vertex : v.getNeighbors()) {
			if(!graph.get(vertex)) {
				explore(vertex, graph);
			}
		}
		return graph;
	}

	public void printGraph() {
		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			System.out.print("\n" + vertex.value + ": ");

			ArrayList<Vertex> neighbors = vertex.getNeighbors();
			for(Vertex v : neighbors) {
				System.out.print(" " + v.value);
			}
		}
		System.out.println();
	}
}
