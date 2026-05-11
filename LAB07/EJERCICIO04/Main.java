package EJERCICIO04;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // inserto datos
        bst.insert(15);
        bst.insert(8);
        bst.insert(22);
        bst.insert(5);
        bst.insert(12);
        bst.insert(18);
        bst.insert(30);

        System.out.println("Representación parenthesize:\n");

        bst.parenthesize();

        System.out.println("\n¿Es un BST válido?");
        System.out.println(bst.isValidBST());
    }
}