package com.erdogan;

public class Main {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        int[] values = {1, 2, 3, 4, 5, 6, 7 , 8, 9};

        for (int value : values) {
            avl.insert(value);
        }

        avl.print();

    }

}
