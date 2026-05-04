package EJERCICIO03;

import actividad1.ExceptionIsEmpty;
import java.util.LinkedList;

class ColaPrioridadMultiple {

    private LinkedList<String>[] queues;
    private int levels;

    public ColaPrioridadMultiple(int levels) {
        this.levels = levels;
        queues = new LinkedList[levels];

        // inicializo cada cola
        for (int i = 0; i < levels; i++) {
            queues[i] = new LinkedList<>();
        }
    }

    public void enqueue(String x, int priority) {
        // agrego en la cola según prioridad
        queues[priority].add(x);
    }

    public boolean isEmpty() {
        // verifico si todas están vacías
        for (int i = 0; i < levels; i++) {
            if (!queues[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
