package EJERCICIO03;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {

        ColaPrioridadMultiple colaPrioridad = new ColaPrioridadMultiple(3);

        // inserto elementos como el ejemplo
        colaPrioridad.enqueue("A", 0);
        colaPrioridad.enqueue("B", 2);
        colaPrioridad.enqueue("C", 1);
        colaPrioridad.enqueue("D", 2);

        try {
            // atiendo por prioridad
            while (!colaPrioridad.isEmpty()) {
                System.out.println(colaPrioridad.dequeue());
            }
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
