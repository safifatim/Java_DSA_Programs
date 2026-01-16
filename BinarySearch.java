class BST {

    // Node class
    class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    // Insert into BST
    Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    // Inorder Traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder Traversal
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder Traversal
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search in BST
    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    // Find minimum value
    int findMin(Node root) {
        while (root.left != null)
            root = root.left;

        return root.data;
    }

    // Find maximum value
    int findMax(Node root) {
        while (root.right != null)
            root = root.right;

        return root.data;
    }

    // Delete a node
    Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node with one or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // Count total nodes
    int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Count leaf nodes
    int countLeafNodes(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    // Height of BST
    int height(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // MAIN METHOD
    public static void main(String[] args) {

        BST tree = new BST();

        int[] elements = {50, 30, 70, 20, 40, 60, 80};

        for (int val : elements)
            tree.root = tree.insert(tree.root, val);

        // Traversals
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        // Search
        System.out.println("Search 60: " + tree.search(tree.root, 60));

        // Delete node 80
        tree.root = tree.delete(tree.root, 80);
        System.out.print("Inorder after deleting 80: ");
        tree.inorder(tree.root);
        System.out.println();

        // Min & Max
        System.out.println("Minimum value: " + tree.findMin(tree.root));
        System.out.println("Maximum value: " + tree.findMax(tree.root));

        // Count nodes
        System.out.println("Total nodes: " + tree.countNodes(tree.root));
        System.out.println("Leaf nodes: " + tree.countLeafNodes(tree.root));

        // Height
        System.out.println("Height of BST: " + tree.height(tree.root));
    }
}
