package test;

import btree.BTree;

public class TestBTree {

    public static void main(String[] args) {

        BTree<Integer> tree =
                new BTree<>(4);

        tree.insert(50);
        tree.insert(20);
        tree.insert(70);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(80);
        tree.insert(25);
        tree.insert(27);
        tree.insert(26);
        tree.insert(65);
        tree.insert(75);
        tree.insert(85);
        tree.insert(5);

        System.out.println(tree);
    }
}