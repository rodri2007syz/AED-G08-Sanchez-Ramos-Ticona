package btree;

public class BTree<E extends Comparable<E>> {

    private BNode<E> root;
    private int orden;

    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E cl) {

        up = false;

        E mediana = push(root, cl);

        if(up) {

            BNode<E> nuevaRaiz =
                    new BNode<>(orden);

            nuevaRaiz.count = 1;
            nuevaRaiz.keys.set(0, mediana);

            nuevaRaiz.childs.set(0, root);
            nuevaRaiz.childs.set(1, nDes);

            if(root != null)
                root.parent = nuevaRaiz;

            if(nDes != null)
                nDes.parent = nuevaRaiz;

            root = nuevaRaiz;
        }
    }

    private E push(BNode<E> current, E cl) {

        int[] pos = new int[1];

        if(current == null) {

            up = true;
            nDes = null;

            return cl;
        }

        boolean found =
                current.searchNode(cl, pos);

        if(found) {

            System.out.println(
                "Clave duplicada: " + cl);

            up = false;

            return null;
        }

        E mediana =
            push(current.childs.get(pos[0]), cl);

        if(up) {

            if(current.nodeFull(orden - 1))
                mediana =
                    dividedNode(current,
                                 mediana,
                                 pos[0]);
            else {

                putNode(current,
                        mediana,
                        nDes,
                        pos[0]);

                up = false;
            }
        }

        return mediana;
    }

    private void putNode(
            BNode<E> current,
            E cl,
            BNode<E> rd,
            int k) {

        int i;

        for(i = current.count - 1;
            i >= k;
            i--) {

            current.keys.set(i + 1,
                    current.keys.get(i));

            current.childs.set(i + 2,
                    current.childs.get(i + 1));
        }

        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);

        if(rd != null)
            rd.parent = current;

        current.count++;
    }

    private E dividedNode(
            BNode<E> current,
            E cl,
            int k) {

        int posMdna;

        if(k <= orden / 2)
            posMdna = orden / 2;
        else
            posMdna = orden / 2 + 1;

        BNode<E> nuevo =
                new BNode<>(orden);

        for(int i = posMdna;
            i < orden - 1;
            i++) {

            nuevo.keys.set(
                    i - posMdna,
                    current.keys.get(i));

            nuevo.childs.set(
                    i - posMdna + 1,
                    current.childs.get(i + 1));
        }

        nuevo.count =
                (orden - 1) - posMdna;

        current.count = posMdna;

        if(k <= orden / 2)
            putNode(current,
                    cl,
                    nDes,
                    k);
        else
            putNode(nuevo,
                    cl,
                    nDes,
                    k - posMdna);

        E median =
            current.keys.get(
                current.count - 1);

        nuevo.childs.set(
                0,
                current.childs.get(
                    current.count));

        current.count--;

        nDes = nuevo;

        return median;
    }

    private String getChildIds(
            BNode<E> node) {

        StringBuilder sb =
                new StringBuilder();

        sb.append("[");

        boolean first = true;

        for(int i = 0;
            i <= node.count;
            i++) {

            BNode<E> child =
                    node.childs.get(i);

            if(child != null) {

                if(!first)
                    sb.append(", ");

                sb.append(child.idNode);

                first = false;
            }
        }

        sb.append("]");

        return sb.toString();
    }

    private String writeTree(
            BNode<E> current) {

        if(current == null)
            return "";

        StringBuilder sb =
                new StringBuilder();

        sb.append(current.idNode)
          .append("\t")
          .append(current.toString())
          .append("\t");

        if(current.parent == null)
            sb.append("--");
        else
            sb.append("[")
              .append(current.parent.idNode)
              .append("]");

        sb.append("\t")
          .append(
              getChildIds(current))
          .append("\n");

        for(int i = 0;
            i <= current.count;
            i++) {

            sb.append(
                writeTree(
                    current.childs.get(i)
                )
            );
        }

        return sb.toString();
    }

    @Override
    public String toString() {

        StringBuilder sb =
                new StringBuilder();

        sb.append(
        "Id.Nodo\tClaves Nodo\tId.Padre\tId.Hijos\n");

        sb.append(
            writeTree(root));

        return sb.toString();
    }
}