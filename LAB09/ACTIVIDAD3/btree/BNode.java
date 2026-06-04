package btree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {

    private static int idContador = 0;

    protected int idNode;
    protected int count;

    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;

    protected BNode<E> parent;

    public BNode(int orden) {

        this.idNode = ++idContador;
        this.count = 0;
        this.parent = null;

        keys = new ArrayList<>();
        childs = new ArrayList<>();

        for(int i = 0; i < orden; i++) {
            keys.add(null);
            childs.add(null);
        }
    }

    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    public boolean nodeEmpty() {
        return count == 0;
    }

    public boolean searchNode(E cl, int[] pos) {

        pos[0] = 0;

        while(pos[0] < count &&
              cl.compareTo(keys.get(pos[0])) > 0) {
            pos[0]++;
        }

        if(pos[0] < count &&
           cl.compareTo(keys.get(pos[0])) == 0)
            return true;

        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("(");

        for(int i = 0; i < count; i++) {

            sb.append(keys.get(i));

            if(i < count - 1)
                sb.append(", ");
        }

        sb.append(")");

        return sb.toString();
    }
}