package EJERCICIO06;

public class NodeAVL extends Node {

    protected int bf;

    public NodeAVL(int data) {

        super(data);

        //factor de equilibrio
        bf = 0;
    }
}