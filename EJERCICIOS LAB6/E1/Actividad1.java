package E6.E1;

public class Actividad1 {
    public interface Queue<E> {
        void enqueue(E x);
        E dequeue() throws ExceptionIsEmpty;
        E front() throws ExceptionIsEmpty;
        boolean isEmpty();
    }
}
