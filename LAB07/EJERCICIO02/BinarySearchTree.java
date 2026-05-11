package EJERCICIO02;

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

    public int findMin(Node root) {

        // avanzo hasta el menor
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public int findMax(Node root) {

        // avanzo hasta el mayor
        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    public int height(Node root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int countLeaves(Node root) {

        if (root == null) {
            return 0;
        }

        // encontré una hoja
        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }
    public void destroyNodes() throws ExceptionIsEmpty {

        if (root == null) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }

        // elimino todos los nodos
        root = null;
    }

    public int countAllNodes(Node root) {

        if (root == null) {
            return 0;
        }

        // cuento todos los nodos
        return 1 + countAllNodes(root.left) + countAllNodes(root.right);
    }
}