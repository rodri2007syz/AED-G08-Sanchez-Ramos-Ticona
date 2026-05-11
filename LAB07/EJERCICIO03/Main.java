package EJERCICIO03;

public class Main {

    public static boolean sameArea(BinarySearchTree bst1, BinarySearchTree bst2) {

        // comparo las áreas
        return bst1.areaBST() == bst2.areaBST();
    }

    public static void main(String[] args) {

        BinarySearchTree bst1 = new BinarySearchTree();

        bst1.insert(15);
        bst1.insert(8);
        bst1.insert(22);
        bst1.insert(5);
        bst1.insert(12);

        BinarySearchTree bst2 = new BinarySearchTree();

        bst2.insert(10);
        bst2.insert(6);
        bst2.insert(20);
        bst2.insert(4);
        bst2.insert(8);

        System.out.println("Árbol 1:");
        System.out.println(bst1);

        System.out.println("Área árbol 1: " + bst1.areaBST());

        System.out.println("\nÁrbol 2:");
        System.out.println(bst2);

        System.out.println("Área árbol 2: " + bst2.areaBST());

        System.out.println("\n¿Tienen la misma área?");
        System.out.println(sameArea(bst1, bst2));
    }
}