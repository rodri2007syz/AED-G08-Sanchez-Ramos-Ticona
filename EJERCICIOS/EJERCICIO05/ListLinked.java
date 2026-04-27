package EJERCICIO05;

public class ListLinked<T> {
    private Nodo<T> first;

    public void insert(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);
        if (first == null) {
            first = nuevo;
        } else {
            Nodo<T> aux = first;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = nuevo;
        }
    }

    public Nodo<T> getFirst() {
        return first;
    }
}

