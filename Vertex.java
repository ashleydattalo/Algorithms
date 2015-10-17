import java.util.ArrayList;
public class Vertex {
	public int value;
	private ArrayList<Vertex> neighbors;
	private HashMap<Vertex, Boolean> children;
	private HashMap<Vertex, Boolean> dottedLine;
	public Vertex (int value) {
		this.value = value;
		neighbors = new ArrayList<Vertex>();
		children = new HashMap<Vertex, Boolean>();
		dottedLine = new HashMap<Vertex, Boolean>();
	}

	public void addNeighbors(Vertex vertex) {
		neighbors.add(vertex);
	}

	public ArrayList<Vertex getNeighbors() {
		return neighbors;
	}

	public void addChildren(Vertex vertex, boolean bool) {
		children.put(vertex, bool);
	}

	public HashMap<Vertex, Boolean> getChildren() {
		return children;
	}

	public void addDottedLine(Vertex vertex, boolean bool) {
		dottedLine.put(vertex, bool);
	}

	public HashMap<Vertex, Boolean> getDottedLine() {
		return dottedLine;
	}
}