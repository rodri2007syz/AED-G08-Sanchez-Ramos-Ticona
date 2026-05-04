package ACTIVIDAD03;

import actividad1.ExceptionIsEmpty;

public class Prueba {
    public static void main(String[] args) {

        PriorityQueueLinkSort<String, Integer> pq = new PriorityQueueLinkSort<>();

        pq.enqueue("A", 1);
        pq.enqueue("B", 3);
        pq.enqueue("C", 2);

        System.out.println("Cola: " + pq);

        try {
            System.out.println("Front: " + pq.front());
            System.out.println("Back: " + pq.back());

            System.out.println("Atendiendo: " + pq.dequeue());
            System.out.println("Cola: " + pq);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
