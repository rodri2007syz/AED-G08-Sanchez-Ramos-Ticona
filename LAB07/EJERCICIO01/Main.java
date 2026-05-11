package EJERCICIO01;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // inserto los datos del ejercicio
        bst.insert(15);
        bst.insert(8);
        bst.insert(22);
        bst.insert(5);
        bst.insert(12);
        bst.insert(18);
        bst.insert(30);

        System.out.println("Recorrido InOrden:");
        bst.inOrder(bst.root);

        System.out.println("\n\nRecorrido PreOrden:");
        bst.preOrder(bst.root);

        System.out.println("\n\nRecorrido PostOrden:");
        bst.postOrder(bst.root);

        System.out.println("\n\nBuscar 12: " + bst.search(bst.root, 12));
        System.out.println("Buscar 50: " + bst.search(bst.root, 50));

        System.out.println("Mínimo: " + bst.findMin(bst.root));
        System.out.println("Máximo: " + bst.findMax(bst.root));

        System.out.println("Altura: " + bst.height(bst.root));

        System.out.println("Cantidad de hojas: " + bst.countLeaves(bst.root));
    }
}