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
    
    

    private NodeAVL rotateSL(NodeAVL node) {

        NodeAVL rightChild = (NodeAVL) node.right;

        // muevo subárbol
        node.right = rightChild.left;

        rightChild.left = node;

        return rightChild;
    }

    private NodeAVL rotateSR(NodeAVL node) {

        NodeAVL leftChild = (NodeAVL) node.left;

        // muevo subárbol
        node.left = leftChild.right;

        leftChild.right = node;

        return leftChild;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {

        NodeAVL rightChild = (NodeAVL) node.right;

        // caso simple izquierda
        if (rightChild.bf == 1) {

            node.bf = 0;
            rightChild.bf = 0;

            node = rotateSL(node);
        }
	// rotación doble derecha izquierda
        else if (rightChild.bf == -1) {

            NodeAVL leftGrandChild = (NodeAVL) rightChild.left;

            if (leftGrandChild.bf == 1) {

                node.bf = -1;
                rightChild.bf = 0;
            }

            else if (leftGrandChild.bf == -1) {

                node.bf = 0;
                rightChild.bf = 1;
            }

            else {

                node.bf = 0;
                rightChild.bf = 0;
            }

            leftGrandChild.bf = 0;

            node.right = rotateSR(rightChild);

            node = rotateSL(node);
        }

        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {

        NodeAVL leftChild = (NodeAVL) node.left;

        // caso simple derecha
        if (leftChild.bf == -1) {

            node.bf = 0;
            leftChild.bf = 0;

            node = rotateSR(node);
        }
	// rotación doble izquierda derecha
        else if (leftChild.bf == 1) {

            NodeAVL rightGrandChild = (NodeAVL) leftChild.right;

            if (rightGrandChild.bf == 1) {

                node.bf = 0;
                leftChild.bf = -1;
            }

            else if (rightGrandChild.bf == -1) {

                node.bf = 1;
                leftChild.bf = 0;
            }

            else {

                node.bf = 0;
                leftChild.bf = 0;
            }

            rightGrandChild.bf = 0;

            node.left = rotateSL(leftChild);

            node = rotateSR(node);
        }

        return node;
    }
}