import java.util.ArrayList;
public class Node {
	private ArrayList<Node> ancestors;
	int value;
	int height;
	Node parent;
	Node child;

	public Node(int value) {
		ancestors = new ArrayList<Node>();
		this.value = value;
	}

	public void addAncestor(Node node) {
		ancestors.add(node);
	}
}