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

        // si está vacío
        if (isEmpty()) {
            first = last = nuevo;
            return;
        }

        // si tiene mayor prioridad que el primero
        if (pr.compareTo(first.getData().priority) > 0) {
            nuevo.setNext(first);
            first = nuevo;
            return;
        }

        Node<EntryNode> aux = first;

        // busco posición según prioridad
        while (aux.getNext() != null &&
               pr.compareTo(aux.getNext().getData().priority) <= 0) {
            aux = aux.getNext();
        }

        nuevo.setNext(aux.getNext());
        aux.setNext(nuevo);

        // si se insertó al final
        if (nuevo.getNext() == null) {
            last = nuevo;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
