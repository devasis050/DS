package tree;

//https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
public class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;
    Color color;
    public Node(T data) {
        this.data = data;
    }
    
    public Node(T data, Color color) {
        this.data = data;
        this.color = color;
    }
    
    public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	public enum Color {
    	RED, BLACK;
    }
}
