package ACTIVIDAD03;

public class BSTree {

    protected Node root;

    public BSTree() {
        root = null;
    }

    public void inOrder(Node root) {

        if (root != null) {

            inOrder(root.left);

            System.out.print(root.data + " ");

            inOrder(root.right);
        }
    }

    public void drawBST(Node root, String space) {

        if (root == null) {
            return;
        }

        // muestro derecha
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
}