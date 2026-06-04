package EJERCICIO01;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {

    private static int nextId = 1;

    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNode;

    public BNode(int n) {

        keys = new ArrayList<E>(n);
        childs = new ArrayList<BNode<E>>(n);
        count = 0;

        idNode = nextId++;

        for (int i = 0; i < n; i++) {
            keys.add(null);
            childs.add(null);
        }
    }

    // verifica si el nodo está lleno
    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    // verifica si el nodo está vacío
    public boolean nodeEmpty() {
        return count == 0;
    }

    // busca una clave dentro del nodo
    public boolean searchNode(E cl, int pos[]) {

        pos[0] = 0;

        while (pos[0] < count &&
               cl.compareTo(keys.get(pos[0])) > 0) {

            pos[0]++;
        }

        if (pos[0] < count &&
            cl.compareTo(keys.get(pos[0])) == 0) {

            return true;
        }

        return false;
    }

    public int getIdNode() {
        return idNode;
    }

    @Override
    public String toString() {

        String s = "[" + idNode + "] ";

        for (int i = 0; i < count; i++) {
            s += keys.get(i) + " ";
        }

        return s;
    }
}