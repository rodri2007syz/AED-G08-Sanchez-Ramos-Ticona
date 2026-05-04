package E6.E4;
import actividad3.PriorityQueueLinkSort; // O la implementacion de lista ordenada que tengas

public class PriorityQueueHybrid<E extends Comparable<E>> {
    private PriorityQueueLinkSort<E, Integer>[] queues;
    private int levels;

    public PriorityQueueHybrid(int levels) {
        this.levels = levels;
        // Creamos un arreglo de colas, una para cada nivel
        queues = new PriorityQueueLinkSort[levels];
        for (int i = 0; i < levels; i++) {
            queues[i] = new PriorityQueueLinkSort<>();
        }
    }

    public void enqueue(E x, int priority, int secondaryValue) {
        if (priority >= 0 && priority < levels) {
            // Primero decides la cola segun prioridad
            // Luego insertas ordenado por el valor secundario
            queues[priority].enqueue(x, secondaryValue); 
        }
    }

    public E dequeue() throws Exception {
        // Recorrer desde la prioridad mas alta (N-1) a la mas baja (0)
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue(); // Retorna el primero disponible del nivel mas alto
            }
        }
        throw new Exception("Todas las colas están vacías");
    }

    public void mostrarEstado() {
        for (int i = levels - 1; i >= 0; i--) {
            System.out.println("Nivel " + i + ": " + (queues[i].isEmpty() ? "vacío" : queues[i].toString()));
        }
    }
}
