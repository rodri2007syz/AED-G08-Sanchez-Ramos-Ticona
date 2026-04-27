package EJERCICIO05;

public class Ejercicio05 {

    public static <T> boolean sonIguales(ListLinked<T> lista1, ListLinked<T> lista2) {
        Nodo<T> nodo1 = lista1.getFirst();
        Nodo<T> nodo2 = lista2.getFirst();

        while (nodo1 != null && nodo2 != null) {
            if (!nodo1.valor.equals(nodo2.valor)) {
                return false;
            }
            nodo1 = nodo1.next;
            nodo2 = nodo2.next;
        }

        return nodo1 == null && nodo2 == null;
    }
}

