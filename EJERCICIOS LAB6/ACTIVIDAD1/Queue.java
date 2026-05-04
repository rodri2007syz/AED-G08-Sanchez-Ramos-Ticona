package ACTIVIDAD1;

// Interfaz genérica para una cola
public interface Queue<E> {
    
    // Inserta un elemento al final de la cola
    void enqueue(E x);

    // Elimina el elemento del frente
    E dequeue() throws ExceptionIsEmpty;

    // Retorna el elemento del frente
    E front() throws ExceptionIsEmpty;

    // Verifica si la cola está vacía
    boolean isEmpty();
}