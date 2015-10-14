import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class Graph {
	private static HashMap<Integer, Vertex> verticies = new HashMap<Integer, Vertex>();

	public static void main(String [] args) throws IOException {
		Graph graph = new Graph();
        BufferedReader br = new BufferedReader(new FileReader("graph.TXT"));
        String line = null;
        int count = 0;
        while ((line = br.readLine()) != null) {
        	String[] splited = line.split("\\s+");

            int value1 = Integer.parseInt(splited[0]);
            int value2 = Integer.parseInt(splited[1]);
            Vertex vertex1 = new Vertex(value1);
            Vertex vertex2 = new Vertex(value2);
            if(verticies.get(value1) == null) {
            	verticies.put(value1, vertex1);
        	}
        	else {
        		vertex1 = verticies.get(value1);
        	}
        	if(verticies.get(value2) == null) {
        		verticies.put(value2, vertex2);
        	}
        	else {
        		vertex2 = verticies.get(value2);
        	}
        	
        	vertex1.addNeighbors(vertex2);
        	vertex2.addNeighbors(vertex1);
        }

        graph.printGraph();

        Vertex v1 = verticies.get(0);
        Vertex v2 = verticies.get(4);
        boolean conn = graph.isConnected(v1, v2);
        System.out.println("connected: " + conn );
        System.out.println("colorable: " + graph.isTwoColorable() );
	}

	public boolean isConnected(Vertex v1, Vertex v2) {
		HashMap<Vertex, Boolean> graph = new HashMap<Vertex, Boolean>();
		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			graph.put(vertex, false);
		}
		graph = explore(v1, graph);
		return graph.get(v2);
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

	public boolean isTwoColorable() {
		HashMap<Vertex, Boolean> graph = new HashMap<Vertex, Boolean>();
		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			graph.put(vertex, false);
		}

		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			graph = exploreColorable(vertex, graph);
		}
		
		boolean colorable = true;
		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			for(Vertex neigh : vertex.getNeighbors()) {
				colorable = graph.get(vertex) != graph.get(neigh);
				System.out.println(vertex.value + " " + neigh.value + graph.get(vertex) + "\n" + graph.get(neigh));
				if(!colorable) {
					return false;
				}
			}
		}

		return colorable;
	}

	public static HashMap<Vertex, Boolean> exploreColorable (Vertex v, HashMap<Vertex, Boolean> graph) {
		for(Vertex vertex : v.getNeighbors()) {
			graph.remove(vertex);
			graph.put(vertex, !graph.get(v));
			//System.out.println(v.value + " " + vertex.value + graph.get(v) + graph.get(vertex) + "\n");
			explore(vertex, graph);
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
