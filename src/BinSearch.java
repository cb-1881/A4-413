//import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BinSearch<T extends Comparable<T>> {

    class TreeNode {
        T value;
        TreeNode left;
        TreeNode right;

        public TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public BinSearch() {
        this.root = null;
    }

    // Insert value into the BST
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, T value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    // Search for a value in the BST
    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode current, T value) {
        if (current == null) {
            return false;
        }
        if (value.compareTo(current.value) == 0) {
            return true;
        }
        return value.compareTo(current.value) < 0
            ? containsNodeRecursive(current.left, value)
            : containsNodeRecursive(current.right, value);
    }

    // Inorder traversal of the BST
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            inorderTraversalRecursive(node.left);
            System.out.print(node.value + " ");
            inorderTraversalRecursive(node.right);
        }
    }

    // Method to delete all nodes in the BST
    public void deleteAll() {
        root = null;
    }

    // Preorder traversal of the BST
    private void preorderTraversal() {
        preorderTraversalRecursive(root);
    }

    private void preorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderTraversalRecursive(node.left);
            preorderTraversalRecursive(node.right);
        }
    }

    // Post-order traversal of the BST
private void postorderTraversal() {
    postorderTraversalRecursive(root);
}

private void postorderTraversalRecursive(TreeNode node) {
    if (node != null) {
        postorderTraversalRecursive(node.left);
        postorderTraversalRecursive(node.right);
        System.out.print(node.value + " ");
    }
}


    // Method to print the tree structure visually
    public void printTree() {
        printSubtree(root, 0);
    }

    private void printSubtree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // Print right subtree
        printSubtree(node.right, level + 1);
        // Print the current node
        printNode(node, level);
        // Print left subtree
        printSubtree(node.left, level + 1);
    }

    private void printNode(TreeNode node, int level) {
        // Indentation for each level
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        if (level > 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("   ");
            }
        }
        System.out.println(node.value.toString());
    }

    public void exportTreeImage(String filename) throws IOException {
        int width = 800; // Set the width of the image
        int height = 600; // Set the height of the image

        // Create a buffered image object
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = buffer.createGraphics();

        // Set the background color to white for visibility
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);

        // Set the font for node values
        graphics2D.setFont(new Font("Arial", Font.BOLD, 14));

        // Initiate the recursive drawing from the root
        drawTree(graphics2D, root, width / 2, 30, width / 4);

        // Dispose the graphics object
        graphics2D.dispose();

        // Write the buffered image to file
        File file = new File(filename);
        ImageIO.write(buffer, "png", file);
    }

    // Recursive method to draw each node and its connections
    private void drawTree(Graphics2D g, TreeNode node, int x, int y, int xOffset) {
        if (node == null) {
            return;
        }

        // Calculate the y-offset for the level spacing
        int yOffset = 50;

        // Draw the current node as a circle with its value
        int nodeRadius = 15;
        int nodeDiameter = nodeRadius * 2;
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x - nodeRadius, y - nodeRadius, nodeDiameter, nodeDiameter);
        g.setColor(Color.BLACK);
        g.drawOval(x - nodeRadius, y - nodeRadius, nodeDiameter, nodeDiameter);

        FontMetrics fm = g.getFontMetrics();
        int textX = x - (fm.stringWidth(node.value.toString()) / 2);
        int textY = y + (fm.getHeight() / 4);
        g.drawString(node.value.toString(), textX, textY);

        // Calculate positions for children
        int leftChildX = x - xOffset;
        int rightChildX = x + xOffset;
        int childY = y + yOffset;

        // Draw the connection to the left child
        if (node.left != null) {
            g.drawLine(x, y + nodeRadius, leftChildX, childY - nodeRadius);
            drawTree(g, node.left, leftChildX, childY, xOffset / 2);
        }

        // Draw the connection to the right child
        if (node.right != null) {
            g.drawLine(x, y + nodeRadius, rightChildX, childY - nodeRadius);
            drawTree(g, node.right, rightChildX, childY, xOffset / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println("===================================\n");
        System.out.println("BINARY SEARCH TREE IMPLEMENTATION\n");
        System.out.println("===================================\n");

        // Example for Integer BST
        BinSearch<Integer> myIntTree = new BinSearch<>();
        myIntTree.insert(10);
        myIntTree.insert(5);
        myIntTree.insert(15);
        myIntTree.insert(3);
        myIntTree.insert(420);
        myIntTree.insert(7);
        myIntTree.insert(18);
        System.out.println("Inorder Traversal:\n");
myIntTree.inorderTraversal();
System.out.println("\n");
System.out.println("Preorder Traversal:\n");
myIntTree.preorderTraversal();
System.out.println("\n");
System.out.println("Postorder Traversal:\n");
myIntTree.postorderTraversal();
System.out.println("\n");
        // Example for String BST
        BinSearch<String> myStringTree = new BinSearch<>();
        myStringTree.insert("kiwi");
        myStringTree.insert("mango");
        myStringTree.insert("date");
        myStringTree.insert("fig");
        myStringTree.insert("grape");
        myStringTree.insert("lemon");
   //string traversals
        myStringTree.inorderTraversal();
        System.out.println("\n");
        System.out.println("Preorder Traversal:\n");
        myStringTree.preorderTraversal();
        System.out.println("\n");
        System.out.println("Postorder Traversal:\n");
        myStringTree.postorderTraversal();
        System.out.println("\n");

        // After all operations on the tree, export the tree to an image
        try {
            myIntTree.exportTreeImage("BST.png");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the image.");
            e.printStackTrace();
        }
    }
}
