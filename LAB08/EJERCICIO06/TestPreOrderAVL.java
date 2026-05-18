package EJERCICIO06;

public class TestPreOrderAVL {

    public static void main(String[] args) {

        // PRUEBA 1

        AVLTree avl1 = new AVLTree();

        avl1.insert(30);
        avl1.insert(20);
        avl1.insert(40);
        avl1.insert(10);
        avl1.insert(25);

        System.out.println("PRUEBA 1 PREORDEN");
        avl1.preOrder(avl1.root);

        System.out.println("\n");

        // PRUEBA 2

        AVLTree avl2 = new AVLTree();

        avl2.insert(50);
        avl2.insert(30);
        avl2.insert(70);
        avl2.insert(60);
        avl2.insert(80);

        System.out.println("PRUEBA 2 PREORDEN");
        avl2.preOrder(avl2.root);

        System.out.println("\n");

        // PRUEBA 3

        AVLTree avl3 = new AVLTree();

        avl3.insert(40);
        avl3.insert(20);
        avl3.insert(60);
        avl3.insert(10);
        avl3.insert(30);

        System.out.println("PRUEBA 3 PREORDEN");
        avl3.preOrder(avl3.root);
    }
}