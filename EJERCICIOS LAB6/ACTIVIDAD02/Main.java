package ACTIVIDAD02;
import actividad1.ExceptionIsEmpty;

public class Main {
    public static void main(String[] args) {

        DequeLink<Integer> deque = new DequeLink<>();

        // agrego elementos
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);

        System.out.println("Deque: " + deque);

        try {
            System.out.println("Primero: " + deque.getFirst());
            System.out.println("Último: " + deque.getLast());

            System.out.println("Eliminando primero: " + deque.removeFirst());
            System.out.println("Eliminando último: " + deque.removeLast());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Deque final: " + deque);
    }
}
