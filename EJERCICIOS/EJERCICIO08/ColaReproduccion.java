package EJERCICIO08;

public class ColaReproduccion<T> {
    private NodeDoble<T> head;
    private NodeDoble<T> tail;
    private NodeDoble<T> actual;

    public void agregarCancion(T valor) {
        NodeDoble<T> nuevo = new NodeDoble<>(valor);

        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.next = nuevo;
            nuevo.prev = tail;
            tail = nuevo;
        }
    }

    public void mostrarCola() {
        NodeDoble<T> temp = head;
        int i = 1;

        while (temp != null) {
            System.out.println(i + ". " + temp.valor);
            temp = temp.next;
            i++;
        }
    }
    
    public T reproducirSiguiente() {
        if (actual == null) {
            actual = head;
        } else if (actual.next != null) {
            actual = actual.next;
        }
        return actual != null ? actual.valor : null;
    }

    public T reproducirAnterior() {
        if (actual != null && actual.prev != null) {
            actual = actual.prev;
        }
        return actual != null ? actual.valor : null;
    }

}
