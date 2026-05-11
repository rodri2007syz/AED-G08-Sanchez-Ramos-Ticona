package EJERCICIO01;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {

        // inserto el nuevo nodo
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // voy por la izquierda
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        }

        // voy por la derecha
        else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public boolean search(Node root, int value) {

        // valor no encontrado
        if (root == null) {
            return false;
        }

        // valor encontrado
        if (root.data == value) {
            return true;
        }

        // busco por la izquierda
        if (value < root.data) {
            return search(root.left, value);
        }

        // busco por la derecha
        return search(root.right, value);
    }

    public void inOrder(Node root) {

        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {

        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {

        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}