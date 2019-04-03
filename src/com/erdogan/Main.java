package com.erdogan;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = new Node(5);
        bst.root = root;

        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int value : values) {
            bst.insert(value);
        }

        bst.delete(2);
        bst.delete(1);
        bst.delete(3);
        bst.delete(5);
        bst.delete(6);


        bst.inOrder();
    }

}
