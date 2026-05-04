package ACTIVIDAD03;

import actividad1.ExceptionIsEmpty;

class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {

    class EntryNode {
        E data;
        N priority;

        EntryNode(E data, N priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void enqueue(E x, N pr) {
        EntryNode nuevoDato = new EntryNode(x, pr);
        Node<EntryNode> nuevo = new Node<>(nuevoDato);

        if (isEmpty()) {
            first = last = nuevo;
            return;
        }

        if (pr.compareTo(first.getData().priority) > 0) {
            nuevo.setNext(first);
            first = nuevo;
            return;
        }

        Node<EntryNode> aux = first;

        while (aux.getNext() != null &&
               pr.compareTo(aux.getNext().getData().priority) <= 0) {
            aux = aux.getNext();
        }

        nuevo.setNext(aux.getNext());
        aux.setNext(nuevo);

        if (nuevo.getNext() == null) {
            last = nuevo;
        }
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue vacía");

        // siempre sale el de mayor prioridad (inicio)
        E dato = first.getData().data;
        first = first.getNext();

        if (first == null)
            last = null;

        return dato;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue vacía");

        // mayor prioridad
        return first.getData().data;
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("Queue vacía");

        // menor prioridad
        return last.getData().data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> aux = first;

        // recorro en orden de prioridad
        while (aux != null) {
            sb.append("(")
              .append(aux.getData().data)
              .append(", p=")
              .append(aux.getData().priority)
              .append(") -> ");
            aux = aux.getNext();
        }

        return sb.toString();
    }
}