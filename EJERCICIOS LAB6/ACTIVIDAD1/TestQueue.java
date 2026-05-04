package ACTIVIDAD1;

public class TestQueue {

    public static void main(String[] args) {

        try {

            // Cola de Integer
            QueueArray<Integer> cola1 = new QueueArray<>(5);

            cola1.enqueue(10);
            cola1.enqueue(20);
            cola1.enqueue(30);

            System.out.println("Cola Integer: " + cola1);

            System.out.println("Elemento al frente: " + cola1.front());

            System.out.println("Elemento eliminado: " + cola1.dequeue());

            System.out.println("Cola después del dequeue: " + cola1);


            System.out.println();


            // Cola de String
            QueueArray<String> cola2 = new QueueArray<>(5);

            cola2.enqueue("Juan");
            cola2.enqueue("Pedro");
            cola2.enqueue("Luis");

            System.out.println("Cola String: " + cola2);

            System.out.println("Elemento al frente: " + cola2.front());

            System.out.println("Elemento eliminado: " + cola2.dequeue());

            System.out.println("Cola después del dequeue: " + cola2);

        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}