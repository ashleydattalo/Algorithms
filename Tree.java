import java.util.ArrayList;
import java.util.HashMap;
public class Tree {
	private ArrayList<Vertex> nodes;
	private HashMap<Integer, Vertex> verticies;
	public Tree(HashMap<Integer, Vertex> verticies) {
		nodes = new ArrayList<Vertex>();	
	}

	public void initTree() {
		for(Integer key : verticies.keySet()) {
			createTree(verticies.get(key));
		}
	}

	private void createTree(Vertex v) {
		if(!nodes.contains(v)) {
			nodes.add(v);
		}
		for(Vertex neigh : v.getNeighbors()) {
			
		}

	}

	public boolean getColorable() {
		//for(all nodes in the tree) {
		// 	make sure that it's color differs from the color of it's child nodes and dotted line nodes
		// }
		return true;
	}

	public ArrayList<Vertex> getNodes() {
		return nodes;
	}
}