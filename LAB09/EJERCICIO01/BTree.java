package EJERCICIO01;

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

        return this.root == null;
    }

    public void insert(E cl) {

        up = false;

        E mediana;
        BNode<E> pnew;

        // inserto recursivamente
        mediana = push(this.root, cl);

        // si la raíz se dividió
        if (up) {

            pnew = new BNode<E>(this.orden);

            pnew.count = 1;
            pnew.keys.set(0, mediana);

            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);

            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {

        int pos[] = new int[1];
        E mediana;

        // llegué a una hoja
        if (current == null) {

            up = true;
            nDes = null;

            return cl;
        }

        boolean fl;

        // busco posición dentro del nodo
        fl = current.searchNode(cl, pos);

        // verifico duplicado
        if (fl) {

            System.out.println("Item duplicado");

            up = false;

            return null;
        }

        // continúo por el hijo correspondiente
        mediana = push(current.childs.get(pos[0]), cl);

        if (up) {

            // reviso si el nodo está lleno
            if (current.nodeFull(this.orden - 1)) {

                mediana = dividedNode(current, mediana, pos[0]);
            }

            else {

                // inserto normalmente
                putNode(current, mediana, nDes, pos[0]);

                up = false;
            }
        }

        return mediana;
    }

    private void putNode(BNode<E> current,
                         E cl,
                         BNode<E> rd,
                         int k) {

        int i;

        // desplazo claves e hijos
        for (i = current.count - 1; i >= k; i--) {

            current.keys.set(i + 1,
                             current.keys.get(i));

            current.childs.set(i + 2,
                               current.childs.get(i + 1));
        }

        // inserto nueva clave
        current.keys.set(k, cl);

        current.childs.set(k + 1, rd);

        current.count++;
    }

    private E dividedNode(BNode<E> current,
                          E cl,
                          int k) {

        BNode<E> rd = nDes;

        int i;
        int posMdna;

        // calculo posición de la mediana
        posMdna = (k <= this.orden / 2)
                ? this.orden / 2
                : this.orden / 2 + 1;

        // creo nodo derecho
        nDes = new BNode<E>(this.orden);

        // copio claves al nuevo nodo
        for (i = posMdna; i < this.orden - 1; i++) {

            nDes.keys.set(i - posMdna,
                          current.keys.get(i));

            nDes.childs.set(i - posMdna + 1,
                            current.childs.get(i + 1));
        }

        nDes.count =
                (this.orden - 1) - posMdna;

        current.count = posMdna;

        // determino dónde insertar
        if (k <= this.orden / 2) {

            putNode(current, cl, rd, k);
        }

        else {

            putNode(nDes,
                    cl,
                    rd,
                    k - posMdna);
        }

        // obtengo la clave mediana
        E median =
                current.keys.get(current.count - 1);

        nDes.childs.set(
                0,
                current.childs.get(current.count));

        current.count--;

        return median;
    }

    @Override
    public String toString() {

        if (isEmpty()) {

            return "BTree is empty...";
        }

        return writeTree(root);
    }

    private String writeTree(BNode<E> current) {

        String s = "";

        if (current != null) {

            // muestro nodo actual
            s += current.toString() + "\n";

            // recorro hijos
            for (int i = 0;
                 i <= current.count;
                 i++) {

                s += writeTree(
                        current.childs.get(i));
            }
        }

        return s;
    }
    public boolean search(E cl) {

        // inicio búsqueda
        return search(root, cl);
    }

    private boolean search(BNode<E> current, E cl) {

        // árbol vacío o clave no encontrada
        if (current == null) {
            return false;
        }

        int pos[] = new int[1];

        // busco dentro del nodo
        boolean found = current.searchNode(cl, pos);

        // clave encontrada
        if (found) {

            System.out.println(
                cl + " se encuentra en el nodo "
                + current.getIdNode()
                + " en la posición "
                + pos[0]
            );

            return true;
        }

        // continúo por el hijo correspondiente
        return search(
                current.childs.get(pos[0]),
                cl
        );
    }
}