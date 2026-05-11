package EJERCICIO04;

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
    public int countNodes(Node root) {

        if (root == null) {
            return 0;
        }

        // ignoro hojas
        if (root.left == null && root.right == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int height(int x) {

        Node current = root;

        // busco el nodo
        while (current != null) {

            if (current.data == x) {
                break;
            }

            if (x < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // nodo no encontrado
        if (current == null) {
            return -1;
        }

        NodeQueue queue = new NodeQueue();

        queue.enqueue(current);

        int height = -1;

        // recorrido por niveles
        while (!queue.isEmpty()) {

            int levelSize = 0;
            NodeQueue tempQueue = new NodeQueue();

            while (!queue.isEmpty()) {

                Node node = queue.dequeue();
                levelSize++;

                if (node.left != null) {
                    tempQueue.enqueue(node.left);
                }

                if (node.right != null) {
                    tempQueue.enqueue(node.right);
                }
            }

            queue = tempQueue;
            height++;
        }

        return height;
    }
    public int amplitude() {

        int max = 0;

        NodeQueue queue = new NodeQueue();

        queue.enqueue(root);

        // recorro nivel por nivel
        while (!queue.isEmpty()) {

            int count = 0;
            NodeQueue tempQueue = new NodeQueue();

            while (!queue.isEmpty()) {

                Node node = queue.dequeue();
                count++;

                if (node.left != null) {
                    tempQueue.enqueue(node.left);
                }

                if (node.right != null) {
                    tempQueue.enqueue(node.right);
                }
            }

            // guardo la mayor amplitud
            if (count > max) {
                max = count;
            }

            queue = tempQueue;
        }

        return max;
    }
    public int areaBST() {

        if (root == null) {
            return 0;
        }

        NodeQueue queue = new NodeQueue();

        queue.enqueue(root);

        int leaves = 0;
        int height = -1;

        // recorrido iterativo por niveles
        while (!queue.isEmpty()) {

            NodeQueue tempQueue = new NodeQueue();

            height++;

            while (!queue.isEmpty()) {

                Node current = queue.dequeue();

                // cuento hojas
                if (current.left == null && current.right == null) {
                    leaves++;
                }

                if (current.left != null) {
                    tempQueue.enqueue(current.left);
                }

                if (current.right != null) {
                    tempQueue.enqueue(current.right);
                }
            }

            queue = tempQueue;
        }

        // hojas por altura
        return leaves * height;
    }
    public void drawBST(Node root, String space) {

        if (root == null) {
            return;
        }

        // muestro primero derecha
        drawBST(root.right, space + "   ");

        System.out.println(space + root.data);

        // muestro izquierda
        drawBST(root.left, space + "   ");
    }
    @Override
    public String toString() {

        drawBST(root, "");

        return "";
    }
    public void parenthesize() {

        parenthesize(root, 0);
    }
    private void parenthesize(Node root, int level) {

        if (root == null) {
            return;
        }

        // aplico sangría
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }

        System.out.print(root.data);

        // verifico hijos
        if (root.left != null || root.right != null) {

            System.out.println(" (");

            parenthesize(root.left, level + 1);

            parenthesize(root.right, level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(")");
        } else {
            System.out.println();
        }
    }
    public boolean isValidBST() {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBST(Node root, int min, int max) {

        if (root == null) {
            return true;
        }

        // verifico rango válido
        if (root.data <= min || root.data >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.data)
                && isValidBST(root.right, root.data, max);
    }
    
}

