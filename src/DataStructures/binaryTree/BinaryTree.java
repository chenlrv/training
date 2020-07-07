package DataStructures.binaryTree;

public class BinaryTree {
    private TreeNode root;


    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public BinaryTree() {
        root = new TreeNode();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void inorderTraversal(TreeNode node) { //left, root, right
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.println(node.getValue());
            inorderTraversal(node.getRight());
        }
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void preorderTraversal(TreeNode node) { //root, left, right
        if (node != null) {
            System.out.println(node.getValue());
            inorderTraversal(node.getLeft());
            inorderTraversal(node.getRight());
        }
    }

    public void postorderTraversal(TreeNode node) { //left, right, root
        if (node != null) {
            inorderTraversal(node.getLeft());
            inorderTraversal(node.getRight());
            System.out.println(node.getValue());
        }
    }

    public void levelOrderTraversal() { //BFS
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.getValue());
        } else {
            printGivenLevel(root.getLeft(), level - 1);
            printGivenLevel(root.getRight(), level - 1);
        }

    }


    public static int sumNitzan(TreeNode<Integer> root, int sum) {
        if (root == null) {
            return 0;
        }

        sum += root.getValue();
        return sumNitzan(root.getLeft(), sum) + sumNitzan(root.getRight(), sum);

    }

    public static int sumChen(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        return root.getValue() + sumChen(root.getLeft()) + sumChen(root.getRight());
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);

        root.setLeft(new TreeNode<>(2, new TreeNode<>(7), new TreeNode<>(8)));
        root.setRight(new TreeNode<>(3, new TreeNode<>(9), new TreeNode<>(11)));

        System.out.println(sumNitzan(root, 0));
        System.out.println(sumChen(root));
/*
        BinaryTree tree = new BinaryTree(root);
        tree.inorderTraversal(tree.getRoot());*/
    }
}
