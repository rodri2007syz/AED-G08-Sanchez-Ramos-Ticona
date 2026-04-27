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
    public void mezclar() {
        if (head == null) return;

        ArrayList<NodeDoble<T>> lista = new ArrayList<>();
        NodeDoble<T> temp = head;

        while (temp != null) {
            lista.add(temp);
            temp = temp.next;
        }

        Collections.shuffle(lista);

        head = lista.get(0);
        head.prev = null;

        NodeDoble<T> actualNodo = head;

        for (int i = 1; i < lista.size(); i++) {
            NodeDoble<T> siguiente = lista.get(i);
            actualNodo.next = siguiente;
            siguiente.prev = actualNodo;
            actualNodo = siguiente;
        }

        tail = actualNodo;
        tail.next = null;
    }

    public int duracionTotal() {
        int total = 0;
        NodeDoble<T> temp = head;

        while (temp != null) {
            total += ((Cancion) temp.valor).getDuracionSeg();
            temp = temp.next;
        }

        return total;
    }

}
