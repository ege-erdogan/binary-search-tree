package com.erdogan;

public class Main {

    public static void main(String[] args) {

        // some example code to see it working

        BinarySearchTree bst = new BinarySearchTree();

        int[] values = {1, 2, 3, 4, 5, 6, 7 , 8, 9};

        for (int value : values) {
            bst.insert(value);
        }

        bst.inOrder();

        bst.find(5);
        bst.find(100);

        bst.delete(3);
        bst.delete(7);

        bst.inOrder();
    }

}
