class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public TreeNode insert(TreeNode node, int data) {
        if (node == null) return new TreeNode(data);

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    void printSorted(TreeNode node, boolean ascending) {
        if (node == null) return;

        if (ascending) {
            printSorted(node.left, ascending);
            System.out.print(node.data + " ");
            printSorted(node.right, ascending);
        } else {
            printSorted(node.right, ascending);
            System.out.print(node.data + " ");
            printSorted(node.left, ascending);
        }
    }
}

public class BSTSort {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.print("Sorted (asc): ");
        tree.printSorted(tree.root, true);
        System.out.println();
        System.out.print("Sorted (desc): ");
        tree.printSorted(tree.root, false);
    }
}