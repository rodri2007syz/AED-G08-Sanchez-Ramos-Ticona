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

        if (isEmpty()) {
            first = last = nuevo;
        } else {
            nuevo.setNext(first);
            first = nuevo;
        }
    }

    @Override
    public void addLast(E x) {
        Node<E> nuevo = new Node<>(x);

        if (isEmpty()) {
            first = last = nuevo;
        } else {
            last.setNext(nuevo);
            last = nuevo;
        }
    }

    @Override
    public E removeFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }

        E dato = first.getData();
        // avanzo el puntero
        first = first.getNext();

        // si quedó vacío, limpio también last
        if (first == null) {
            last = null;
        }

        return dato;
    }

    @Override
    public E removeLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }

        E dato = last.getData();

        // si solo hay uno
        if (first == last) {
            first = last = null;
        } else {
            Node<E> aux = first;

            // busco el penúltimo
            while (aux.getNext() != last) {
                aux = aux.getNext();
            }

            aux.setNext(null);
            last = aux;
        }

        return dato;
    }

    @Override
    public E getFirst() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }

        // retorno el primero
        return first.getData();
    }

    @Override
    public E getLast() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Deque vacío");
        }

        // retorno el último
        return last.getData();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> aux = first;

        // recorro toda la lista
        while (aux != null) {
            sb.append(aux.getData()).append(" -> ");
            aux = aux.getNext();
        }

        return sb.toString();
    }
}
