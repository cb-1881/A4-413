import javax.swing.tree.TreeNode;

public class BinSearch {

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    
        public TreeNode(int value) {
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
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    // Search for a value in the BST
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        } 
        if (value == current.value) {
            return true;
        } 
        return value < current.value
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

    // Delete a value from the BST
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node with no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Node with one child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Node with two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(TreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    // Method to delete all nodes in the BST
    public void deleteAll() {
        root = null;
    }



    public static void main(String[] args) {
        System.out.println("===================================\n");
        System.out.println("BINARY SEARCH TREE IMPLEMENTATION\n");
        System.out.println("===================================\n");

        BinSearch my_tree = new BinSearch();

        my_tree.insert(45);
        my_tree.insert(15);
        my_tree.insert(71);
        my_tree.inorderTraversal();

        System.out.println("deleting 15 from tree\n");
        my_tree.delete(15);
        my_tree.inorderTraversal();
        System.out.println("deleting all\n");
        my_tree.deleteAll();
        my_tree.inorderTraversal();
    }
}
