package ACTIVIDAD03;

public class AVLTree extends BSTree {

    protected boolean height;

    public AVLTree() {

        super();

        height = false;
    }
    public void insert(int data) {

        root = insertAVL((NodeAVL) root, data);
    }

    private NodeAVL insertAVL(NodeAVL node, int data) {

        // inserto nuevo nodo
        if (node == null) {

            height = true;

            return new NodeAVL(data);
        }

        // inserto por izquierda
        if (data < node.data) {

            node.left = insertAVL((NodeAVL) node.left, data);

            if (height) {

                node.bf--;

                // reviso desbalance
                if (node.bf == -2) {

                    node = balanceToRight(node);

                    height = false;
                }

                else if (node.bf == 0) {
                    height = false;
                }
            }
        }

        // inserto por derecha
        else if (data > node.data) {

            node.right = insertAVL((NodeAVL) node.right, data);

            if (height) {

                node.bf++;

                // reviso desbalance
                if (node.bf == 2) {

                    node = balanceToLeft(node);

                    height = false;
                }

                else if (node.bf == 0) {
                    height = false;
                }
            }
        }

        return node;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {

        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {

        return node;
    }
}
