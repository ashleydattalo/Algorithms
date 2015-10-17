import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;  
public class Main {
    public static void main(String [] args) throws IOException {
        HashMap<Integer, Vertex> verticies = new HashMap<Integer, Vertex>();
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

        Graph graph = new Graph(verticies);
        graph.printGraph();
        System.out.println("connected: " + graph.isConnected() );


        Tree tree = new Tree(verticies);
        //System.out.println(tree.isColorable());

        for(Vertex v : tree.getNodes()) {
            System.out.println(v.value);
        }
	}
}