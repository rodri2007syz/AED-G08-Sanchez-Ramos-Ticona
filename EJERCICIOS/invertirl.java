package L5.E1;
import java.util.LinkedList

public class invertirl {
    public static <T> LinkedListss<T> invertirLista(LinkedList<T> lista) {
    LinkedList<T> nuevaLista = new LinkedList<>();
    
    for (T elemento : lista) {
        // Al insertar siempre al inicio, el último elemento de la original
        // terminará siendo el primero de la nueva.
        nuevaLista.insertFirst(elemento); 
    }
    
    return nuevaLista;
}
}
