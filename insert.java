package L5.E1;

import org.w3c.dom.Node;
s
public class insert {
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevoNodo = new Node<>(valor);
    
        // Caso 1: La lista está vacía
        if (head == null) {
            return nuevoNodo;
        }
    
    // Caso 2: Recorrer hasta el final
        Node<T> actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
    
        // Conectamos el último nodo con el nuevo
        actual.setNext(nuevoNodo);
        
        return head;
    }
}
