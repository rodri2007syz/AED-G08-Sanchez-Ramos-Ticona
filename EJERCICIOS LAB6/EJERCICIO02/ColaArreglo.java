package EJERCICIO02;

import actividad1.ExceptionIsEmpty;

class ColaArreglo {

    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ColaArreglo(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        // vacío si no hay elementos
        return size == 0;
    }

    public boolean isFull() {
        // lleno si llega a la capacidad
        return size == capacity;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Cola llena");
            return;
        }

        // incremento circular
        rear = (rear + 1) % capacity;
        array[rear] = x;
        size++;
    }
}
