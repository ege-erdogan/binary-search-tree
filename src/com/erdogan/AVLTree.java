package com.erdogan;

public class AVLTree {

    AVLNode root;

    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    private AVLNode insertHelper(AVLNode rootNode, int data) {
        if (rootNode == null) {
            return new AVLNode(data);
        }

        if (data < rootNode.data) {
            rootNode.left = insertHelper(rootNode.left, data);
        } else if (data > rootNode.data) {
            rootNode.right = insertHelper(rootNode.right, data);
        } else {
            return rootNode;
        }

        rootNode.height = 1 + Math.max(height(rootNode.right), height(rootNode.left));

        if (isBalanced(rootNode) == -1) {
            if (data < rootNode.left.data) {
                return rightRotate(rootNode);
            } else {
                rootNode.left = leftRotate(rootNode.left);
                return leftRotate(rootNode);
            }
        } else if (isBalanced(rootNode) == 1) {
            if (data < rootNode.right.data) {
                rootNode.right = leftRotate(rootNode.right);
                return rightRotate(rootNode);
            } else {
                return leftRotate(rootNode);
            }
        }

        return rootNode;

    }

    public void delete(int data) {
        root = deleteHelper(root, data);
    }

    private AVLNode deleteHelper(AVLNode rootNode, int data) {
        // standard BST deletion
        if (rootNode == null) {
            return rootNode;
        }

        if (data < rootNode.data) {
            rootNode.left = deleteHelper(rootNode.left, data);
        } else if (data > rootNode.data) {
            rootNode.right = deleteHelper(rootNode.right, data);
        } else {
            // we found the root to delete if the key is the same
            if (rootNode.left == null || rootNode.right == null) {
                AVLNode child = (rootNode.right == null) ? rootNode.left : rootNode.right;
                if (child == null) {
                    child = rootNode;
                    rootNode = null;
                } else  {
                    rootNode = child;
                }
            } else {
                AVLNode replacement = minNode(rootNode);
                rootNode.data = replacement.data;
                rootNode.right = deleteHelper(rootNode, replacement.data);
            }
        }

        // update height
        rootNode.height = Math.max(height(rootNode.left), height(rootNode.right));

        if (isBalanced(rootNode) == -1) {
            if (data < rootNode.left.data) {
                return rightRotate(rootNode);
            } else {
                rootNode.left = leftRotate(rootNode.left);
                return leftRotate(rootNode);
            }
        } else if (isBalanced(rootNode) == 1) {
            if (data < rootNode.right.data) {
                rootNode.right = leftRotate(rootNode.right);
                return rightRotate(rootNode);
            } else {
                return leftRotate(rootNode);
            }
        }

        return rootNode;
    }

    private AVLNode minNode(AVLNode rootNode) {
        if (rootNode.left == null) {
            return rootNode;
        } else {
            return minNode(rootNode.left);
        }
    }

    // returns -1, 0, 1 corresponding to left skewed, balanced, and right skewed
    private int isBalanced(AVLNode rootNode) {
        int skew = height(rootNode.right) - height(rootNode.left);
        if (skew < -1) {
            return -1;
        } else if (skew > 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private AVLNode rightRotate(AVLNode rootNode) {
        AVLNode x = rootNode.left;
        AVLNode t2 = x.right;

        x.right = rootNode;
        rootNode.left = t2;

        rootNode.height = Math.max(height(rootNode.left), height(rootNode.right));
        x.height = Math.max(height(x.left), height(x.right));

        return x;
    }

    private AVLNode leftRotate(AVLNode rootNode) {
        AVLNode y = rootNode.right;
        AVLNode t2 = y.left;

        y.left = rootNode;
        rootNode.right = t2;

        rootNode.height = Math.max(height(rootNode.right), height(rootNode.left));
        y.height = Math.max(height(y.right), height(y.left));

        return y;
    }

    public void print() {
        System.out.println();
        inOrderHelper(root);
    }

    private void inOrderHelper(AVLNode rootNode) {
        if (rootNode != null) {
            inOrderHelper(rootNode.left);
            System.out.print(rootNode.data + " ");
            inOrderHelper(rootNode.right);
        }
    }


}
