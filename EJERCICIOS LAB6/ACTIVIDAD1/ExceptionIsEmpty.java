package ACTIVIDAD1;

// Excepción personalizada para cola vacía
public class ExceptionIsEmpty extends Exception {

    public ExceptionIsEmpty(String message) {
        super(message);
    }
}