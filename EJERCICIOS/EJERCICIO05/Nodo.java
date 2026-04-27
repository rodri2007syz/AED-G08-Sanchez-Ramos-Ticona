package EJERCICIO05;


public class Nodo<T> {
    public T valor;
    public Nodo<T> next;

    public Nodo(T valor) {
        this.valor = valor;
        this.next = null;
    }
}
