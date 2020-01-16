package tree;


public class TreeUtils {

	public static <T extends Comparable<?>> Node<T> getUncleNode(Node<T> root, T value) {
		Node<T> uncle = null;
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			uncle = getUncleNode(root, root.left, value);
		}
		if (uncle == null && root.right != null) {
			uncle = getUncleNode(root, root.right, value);
		}
		return uncle;
	}

	private static <T extends Comparable<?>> Node<T> getUncleNode(Node<T> parent, Node<T> node, T value) {
		
		Node<T> uncle = null;
		if ((node.left != null && value.equals(node.left.data))
				|| (node.right != null && value.equals(node.right.data))) {
			uncle = parent.left == node ? parent.right : parent.left;
		}
		if (uncle == null && node.left != null) {
			uncle = getUncleNode(node, node.left, value);
		}
		if (uncle == null && node.right != null) {
			uncle = getUncleNode(node, node.right, value);
		}
		return uncle;
	}
	
	public static <T extends Comparable<?>> Node<T> getGrandParentNode(Node<T> root, T value) {
		return root == null ? null : getGrandParentNode(null, root, value);
	}
	
	private static <T extends Comparable<?>> Node<T> getGrandParentNode(Node<T> parent, Node<T> node, T value) {
		
		if ((node.left != null && value.equals(node.left.data))
				|| (node.right != null && value.equals(node.right.data))) {
			return parent;
		} else {
			Node<T> uncle = null;
			if(node.left != null) {
				uncle = getGrandParentNode(node, node.left, value);
			}
			
			if(uncle == null && node.right != null) {
				uncle = getGrandParentNode(node, node.right, value);
			}
			return uncle;
		}
	}

	public static <T extends Comparable<?>> Node<T> getSibblingNode(Node<T> node, T value) {
		
		if(node == null || node.data.equals(value)) {
			return null;
		}
		else if(node.left != null && node.left.data.equals(value)) {
			return node.right;
		}
		else if(node.right != null && node.right.data.equals(value)) {
			return node.left;
		}
		else {
			Node<T> sibbling = null;
			if(node.left != null) {
				sibbling = getSibblingNode(node.left, value);
			}
			if(sibbling == null && node.right != null) {
				sibbling = getSibblingNode(node.right, value);
			}
			return sibbling;
		}
	}
	
	public static <T extends Comparable<?>> Node<T> getParent(Node<T> root, T value) {
		
		if(root == null || root.data.equals(value)) {
			return null;
		} 
		else if((root.left != null && root.left.data.equals(value)) || (root.right != null && root.right.data.equals(value))) {
			return root;
		}
		else {
			Node<T> parent = null;
			if(root.left != null) {
				parent = getParent(root.left, value);
			}
			
			if(parent == null && root.right != null) {
				parent = getParent(root.right, value);
			}
			
			return parent;
		}
	}
	
	public static <T extends Comparable<?>> Node<T> getNode(Node<T> root, T value) {
		if(root.data.equals(value)) {
			return root;
		}
		else {
			Node<T> node = null;
			if(root.left != null) {
				node = getNode(root.left, value);
			}
			if(node == null && root.right != null) {
				node = getNode(root.right, value);
			}
			return node;
		}
	}
	
	//Rotate Node
	public static <T extends Comparable<?>> Node<T> rotate(Node<T> root, Node<T> node) {
		
		Node<T> parent = getParent(root, node.data);
		Node<T> grandParent = getGrandParentNode(root, node.data);
		
		if(parent == null || grandParent == null) {
			throw new RuntimeException("Rotation not possible");
		}
		
		if(grandParent.left == parent) {
			//LL
			if(parent.left == node) {
				return rotateLL(root, parent, grandParent, node);
			}
			//LR
			else { //if(parent.right == node)
				
				grandParent.left = node;
				parent.right = node.left;
				node.left = parent;
				return rotateLL(root, node, grandParent, parent);
			}
		} 
		else { // if(grandParent.right == parent)
			//RL
			if(parent.left == node) {
				
				grandParent.right = node;
				parent.left = node.right;
				node.right = parent;
				return rotateRR(root, node, grandParent, parent);
			}
			//RR
			else  { //if(parent.right == node)
				return rotateRR(root, parent, grandParent, node);
			}
		}
		
	}

	private static <T extends Comparable<?>> Node<T> rotateLL(Node<T> root, Node<T> parent, Node<T> grandParent, Node<T> node) {
		
		Node<T> sibbling = getSibblingNode(root, node.data);
		Node<T> ggp = getParent(root, grandParent.data);
		if(grandParent == root) {
			root = parent; // parent is the new root
		} 
		else {
			if(ggp.left == grandParent) {
				ggp.left = parent;
			}
			else {
				ggp.right = parent;
			}
		}
		
		parent.right = grandParent;
		grandParent.left = sibbling;
		return root;
	}
	
	private static <T extends Comparable<?>> Node<T> rotateRR(Node<T> root, Node<T> parent, Node<T> grandParent, Node<T> node) {
		Node<T> sibbling = getSibblingNode(root, node.data);
		Node<T> ggp = getParent(root, grandParent.data);
		if(grandParent == root) {
			root = parent; // parent is the new root
		} 
		else {
			if(ggp.left == grandParent) {
				ggp.left = parent;
			}
			else {
				ggp.right = parent;
			}
		}
		grandParent.right = sibbling;
		parent.left = grandParent;
		
		return root;
	}
	
}
 