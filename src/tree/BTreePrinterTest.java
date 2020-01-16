package tree;

//https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
public class BTreePrinterTest {
    private static Node<Integer> test2() {
        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(3);
        Node<Integer> n21 = new Node<Integer>(2);
        Node<Integer> n22 = new Node<Integer>(6);
        Node<Integer> n23 = new Node<Integer>(9);
        Node<Integer> n31 = new Node<Integer>(5);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {
    	Node<Integer> root = test2();
        BTreePrinter.printNode(root);
        BTreePrinter.printNode(TreeUtils.rotate(root, TreeUtils.getNode(root, 9)));
    }
}
