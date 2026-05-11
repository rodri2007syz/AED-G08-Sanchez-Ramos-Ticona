package EJERCICIO02;


public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // inserto datos del árbol
        bst.insert(15);
        bst.insert(8);
        bst.insert(22);
        bst.insert(5);
        bst.insert(12);
        bst.insert(18);
        bst.insert(30);

        System.out.println("Total nodos: " + bst.countAllNodes(bst.root));

        System.out.println("Nodos no-hojas: " + bst.countNodes(bst.root));

        System.out.println("Altura subárbol 22: " + bst.height(22));

        System.out.println("Amplitud: " + bst.amplitude());

        try {

            bst.destroyNodes();

            System.out.println("Árbol eliminado correctamente");

        } catch (ExceptionIsEmpty e) {

            System.out.println(e.getMessage());
        }
    }
}