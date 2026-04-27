package EJERCICIO08;

public class NodeDoble<T> {
    T valor;
    NodeDoble<T> next;
    NodeDoble<T> prev;

    public NodeDoble(T valor) {
        this.valor = valor;
    }
}
