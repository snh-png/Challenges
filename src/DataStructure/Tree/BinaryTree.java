package DataStructure.Tree;

public class BinaryTree {
    public Node root;
    static int max_level = 0;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int data) {
        Node node = new Node(data);
        this.root = node;
    }

//    public BinaryTree(List<T> dataList) {
//        this.root = null;
//        for (T data: dataList) {
//            insert(data);
//        }
//    }

    static class Node {
        public int data;
        public Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(15);
        tree.root.right.left = new Node(12);
        tree.root.right.right.left = new Node(14);

        tree.leftViewUtil(tree.root, 1);
    }

    void leftViewUtil(Node node, int level)
    {
        // Base Case
        if (node == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + node.data);
            max_level = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

//    void lev
}
