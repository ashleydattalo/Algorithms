import java.util.ArrayList;
public class Vertex {
	public int value;
	private ArrayList<Vertex> neighbors;
	public Vertex (int value) {
		this.value = value;
		neighbors = new ArrayList<Vertex>();
	}

	public void addNeighbors(Vertex vertex) {
		neighbors.add(vertex);
	}

	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}
}