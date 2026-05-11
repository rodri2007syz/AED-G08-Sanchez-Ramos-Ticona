package EJERCICIO04;

public class NodeQueue {

    private static class QueueNode {
        Node data;
        QueueNode next;

        public QueueNode(Node data) {
            this.data = data;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public NodeQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Node data) {

        QueueNode newNode = new QueueNode(data);

        // inserto el nodo en la cola
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Node dequeue() {

        if (isEmpty()) {
            return null;
        }

        Node temp = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return temp;
    }
}