package EJERCICIO05;

public class LinkedBST<E extends Comparable<E>> {

    // Clase nodo
    class Node {

        E data;
        Node left;
        Node right;

        // Constructor
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Raiz del arbol
    private Node root;

    // Constructor
    public LinkedBST() {
        root = null;
    }

    // Inserta elementos
    public void insert(E data) {
        root = insertRec(root, data);
    }

    // Insercion recursiva
    private Node insertRec(Node node, E data) {

        // Si el nodo esta vacio
        if (node == null) {
            return new Node(data);
        }

        // Inserta izquierda
        if (data.compareTo(node.data) < 0) {

            node.left = insertRec(node.left, data);

        }
        // Inserta derecha
        else if (data.compareTo(node.data) > 0) {

            node.right = insertRec(node.right, data);
        }

        return node;
    }

    // Muestra elementos en un rango
    public void searchRange(E min, E max) {

        searchRangeRec(root, min, max);
    }

    // Busqueda recursiva
    private void searchRangeRec(Node node, E min, E max) {

        if (node == null) {
            return;
        }

        // Recorre izquierda
        if (min.compareTo(node.data) < 0) {

            searchRangeRec(node.left, min, max);
        }

        // Verifica rango
        if (min.compareTo(node.data) <= 0 &&
                max.compareTo(node.data) >= 0) {

            System.out.println(node.data);
        }

        // Recorre derecha
        if (max.compareTo(node.data) > 0) {

            searchRangeRec(node.right, min, max);
        }
    }

    // Cuenta hojas
    public int countLeaves() {

        return countLeavesRec(root);
    }

    // Conteo recursivo
    private int countLeavesRec(Node node) {

        if (node == null) {
            return 0;
        }

        // Si es hoja
        if (node.left == null && node.right == null) {

            return 1;
        }

        return countLeavesRec(node.left)
                + countLeavesRec(node.right);
    }

    // Muestra descendente
    public void printDescending() {

        printDescendingRec(root);
    }

    // Recorrido descendente
    private void printDescendingRec(Node node) {

        if (node != null) {

            printDescendingRec(node.right);

            System.out.println(node.data);

            printDescendingRec(node.left);
        }
    }
}