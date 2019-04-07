package com.erdogan;

public class BinarySearchTree {

    Node root;
    int size;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
        size++;
    }

    private Node insertHelper(Node rootNode, int value) {
        if (rootNode == null) {
            Node newNode = new Node(value);
            rootNode = newNode;
        } else if (rootNode.data < value) {
            rootNode.right = insertHelper(rootNode.right, value);
        } else {
            rootNode.left = insertHelper(rootNode.left, value);
        }

        return rootNode;
    }

    public boolean find(int value) {
        return findHelper(root, value);
    }

    private boolean findHelper(Node rootNode, int value) {
        if (rootNode == null) {
            return false;
        }

        if (rootNode.data == value) {
            return true;
        } else if (rootNode.data < value) {
            return findHelper(rootNode.right, value);
        } else {
            return findHelper(rootNode.left, value);
        }
    }

    public void delete(int value) {
        root = deleteHelper(root, value);
        size--;
    }

    private Node deleteHelper(Node rootNode, int value) {
        if (rootNode == null) {
            return null;
        }

        if (rootNode.data > value) {
            rootNode.left = deleteHelper(rootNode.left, value);
        } else if (rootNode.data < value) {
            rootNode.right = deleteHelper(rootNode.right, value);
        } else {
            if (rootNode.left == null) {
                return rootNode.right;
            } else if (rootNode.right == null) {
                return rootNode.left;
            }

            rootNode.data = minHelper(rootNode);
            rootNode.right = deleteHelper(rootNode.right, rootNode.data);
        }

        return rootNode;
    }

    public int min() {
        return minHelper(root);
    }

    private int minHelper(Node rootNode) {
        if (rootNode == null) {
            return 0;
        } else if (rootNode.left == null) {
            return rootNode.data;
        } else {
            return minHelper(rootNode.left);
        }
    }

    public void print() {
        System.out.println();
        inOrderHelper(root);
    }

    private void inOrderHelper(Node rootNode) {
        if (rootNode != null) {
            inOrderHelper(rootNode.left);
            System.out.print(rootNode.data + " ");
            inOrderHelper(rootNode.right);
        }
    }


}
