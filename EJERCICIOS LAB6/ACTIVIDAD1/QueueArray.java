package ACTIVIDAD1;

class QueueArray<E> implements Queue<E> {

    // Arreglo donde se almacenan los elementos
    private E[] array;

    // Frente de la cola
    private int front;

    // Final de la cola
    private int rear;

    // Cantidad de elementos
    private int size;

    // Constructor
    public QueueArray(int n) {
        array = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Inserta un elemento al final de la cola
    public void enqueue(E x) {

        // Verifica si la cola está llena
        if (isFull()) {
            System.out.println("Cola llena");
            return;
        }

        // Movimiento circular
        rear = (rear + 1) % array.length;

        // Inserta el elemento
        array[rear] = x;

        // Aumenta el tamaño
        size++;
    }

    // Elimina el elemento del frente
    public E dequeue() throws ExceptionIsEmpty {

        // Verifica si está vacía
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }

        // Guarda el elemento del frente
        E aux = array[front];

        // Movimiento circular
        front = (front + 1) % array.length;

        // Reduce el tamaño
        size--;

        return aux;
    }

    // Retorna el elemento del frente
    public E front() throws ExceptionIsEmpty {

        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }

        return array[front];
    }

    // Verifica si está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Verifica si está llena
    public boolean isFull() {
        return size == array.length;
    }

    // Muestra los elementos de la cola
    public String toString() {

        String cad = "";

        // Recorre la cola desde front hasta rear
        for (int i = 0; i < size; i++) {
            int pos = (front + i) % array.length;
            cad += array[pos] + " ";
        }

        return cad;
    }
}