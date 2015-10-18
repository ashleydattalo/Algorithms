import java.util.ArrayList;
import java.util.HashMap;
public class Tree {
	private Node root;
	private boolean isColorable;
	public Tree(HashMap<Integer, Vertex> verticies) {
		isColorable = true;
		for(Integer key : verticies.keySet()) {
			Vertex vertex = verticies.get(key);
			root = new Node(vertex.value);
			root.height = 0;
			root.parent = null;
			createTree(root, vertex);
		}
	}

	public void createTree(Node node, Vertex vertex) {
		if(vertex.getNeighbors().size() == 0) {
			return;
		}
		for(Vertex neigh : vertex.getNeighbors()) {
			Node child = inTree(root, neigh);
			if(child == null) {
				Node newNode = new Node(neigh.value);
				newNode.parent = node;
				newNode.height = newNode.parent.height + 1;
				node.child = newNode;
				createTree(newNode, neigh);
			}
			else {
				node.addAncestor(child);
				if((node.height - child.height) % 2 == 0) {
					isColorable = false;
				}
			}
		}
	}

	public void printTree( Node curr , int indent )
    {
        indent++;
        if( curr == null )
        {
            return;
        } 
        String indentStr = "";
        for( int i = 0; i < indent ; i++ )
        {
            indentStr += "     ";
        }
        System.out.println( indentStr + curr.value ); 
        printTree( curr.child , indent);
    }

	public Node inTree(Node curr, Vertex v) {
		if(curr.value == v.value) {
			return curr;
		}
		if(curr.child != null) {

			return inTree(curr.child, v);
		}
		return null;
	}

	public boolean isColorable() {
		return isColorable;
	}

	public Node getRoot() {
		return root;
	}
}