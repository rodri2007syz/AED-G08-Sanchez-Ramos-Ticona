package actividadPilaLista;
import Actividad1.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
    private Node<E> top; // Es el inicio de la lista

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top); // El nuevo apunta al antiguo tope
        top = newNode;        // El nuevo se convierte en el tope
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        E aux = top.getData();
        top = top.getNext();  // El tope ahora es el siguiente nodo
        return aux;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        String s = "Tope -> ";
        Node<E> actual = top;
        while (actual != null) {
            s += actual.getData() + " | ";
            actual = actual.getNext();
        }
        return s;
    }
}
