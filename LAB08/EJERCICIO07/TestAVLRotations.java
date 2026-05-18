package EJERCICIO07;

import EJERCICIO06.AVLTree;

public class TestAVLRotations {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        // inserciones AVL
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);

        System.out.println("DESPUÉS DE INSERTAR 30 20 10");
        System.out.println(avl);

        avl.insert(40);
        avl.insert(50);

        System.out.println("DESPUÉS DE INSERTAR 40 50");
        System.out.println(avl);

        avl.insert(25);

        System.out.println("DESPUÉS DE INSERTAR 25");
        System.out.println(avl);
    }
}
