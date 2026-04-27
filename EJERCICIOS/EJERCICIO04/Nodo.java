package EJERCICIO04;

public class Nodo<T> {
    T valor;
    public Nodo<T> next;

    public Nodo(T valor) {
        this.valor = valor;
        this.next = null;
    }

    public static <T> int contarNodos(Nodo<T> head) {
        int contador = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }
}

