/*
package DataStructure.Graph;

import DataStructure.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class IdenticalBTree {
    public static class BinaryTreeNode {


    }
        // Function to check if the two trees are identical
        public static boolean areIdentical(BinaryTreeNode tree1, BinaryTreeNode tree2) {
            // Returns true if both trees have null as tree (first base case)
            if (tree1 == null && tree2 == null) {
                return true;
            }

            // Function returns false if one of the trees here is null (second base case)
            if (tree1 != null && tree2 != null) {
                // Returns true if both nodes have the same left sub-tree, right sub-tree
                // and value
                return (areIdentical(tree1.left, tree2.left) && areIdentical(tree1.right, tree2.right)
                        && (tree1.data == tree2.data));
            }

            // Returns false if neither of the above cases is satisfied
            return false;
        }

        public static void main(String[] argv) {
            // Creating first binary tree with tree as tree1
            List<Integer> input1 = new ArrayList<Integer>();
            input1.add(100);
            input1.add(50);
            input1.add(200);
            input1.add(25);
            input1.add(125);
            input1.add(350);
            BinaryTree tree1 = new BinaryTree(input1);

            // Creating second binary tree with different values and structure,
            List<Integer> input2 = new ArrayList<Integer>();
            input2.add(4);
            input2.add(2);
            input2.add(6);
            input2.add(1);
            input2.add(5);
            input2.add(7);
            BinaryTree tree2 = new BinaryTree(input2);

            // Creating third binary tree with different structure and same values as
            // tree1
            List<Integer> input3 = new ArrayList<Integer>();
            input3.add(100);
            input3.add(25);
            input3.add(200);
            input3.add(50);
            input3.add(125);
            input3.add(350);
            BinaryTree tree1DiffLayout = new BinaryTree(input3);

            // Defining Test Cases
            BinaryTreeNode[] testCaseRoot1 = {tree1.root, tree1.root, tree1.root, tree1.root, null};
            BinaryTreeNode[] testCaseRoot2 = {tree1.root, tree2.root, tree1DiffLayout.root, null, null};

            for (int i = 0; i < testCaseRoot1.length; i++) {
                if (i > 0) {
                    System.out.print("\n");
                }

                // Displaying level-order traversal of trees being tested
                System.out.println((i + 1) + ".\tFirst binary tree:  ");
                TreePrint.displayTree(testCaseRoot1[i]);
                System.out.println("\n\tSecond binary tree: ");
                TreePrint.displayTree(testCaseRoot2[i]);
                System.out.print("\n\tIdentical Tree: ");

                // Calling our areIdentical() function to check if tree are identical
                if (areIdentical(testCaseRoot1[i], testCaseRoot2[i])) {
                    System.out.print("true");
                } else {
                    System.out.print("false");
                }
                System.out.print(
                        "\n----------------------------------------------------------------------------------------------------\n");
            }
        }
}
*/
