package ACTIVIDAD02;

import actividad1.ExceptionIsEmpty;

class DequeLink<E> implements Deque<E> {

    private Node<E> first;
    private Node<E> last;

    public DequeLink() {
        first = null;
        last = null;
    }

    @Override
    public void addFirst(E x) {
        Node<E> nuevo = new Node<>(x);

        // si está vacío, ambos apuntan al mismo nodo
        if (isEmpty()) {
            first = last = nuevo;
        } else {
            // inserto al inicio
            nuevo.setNext(first);
            first = nuevo;
        }
    }

    @Override
    public void addLast(E x) {
        Node<E> nuevo = new Node<>(x);

        // mismo caso cuando está vacío
        if (isEmpty()) {
            first = last = nuevo;
        } else {
            // agrego al final
            last.setNext(nuevo);
            last = nuevo;
        }
    }

    @Override
    public boolean isEmpty() {
        // vacío si no hay primer nodo
        return first == null;
    }
}
