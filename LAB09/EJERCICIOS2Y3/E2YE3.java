package EjerciciosLab9;

public class E2 {
    public void searchRange(E min, E max) {
    if (min.compareTo(max) > 0) {
        System.out.println("Rango inválido");
        return;
    }
    System.out.print("Claves en rango: ");
    searchRangeRec(this.root, min, max);
    System.out.println();
}

private void searchRangeRec(BNode<E> current, E min, E max) {
    if (current == null) return;
    
    int i;
    for (i = 0; i < current.count; i++) {
        E key = current.keys.get(i);
        // Si la clave actual es mayor al mínimo, explorar el hijo izquierdo
        if (key.compareTo(min) > 0) {
            searchRangeRec(current.childs.get(i), min, max);
        }
        // Si está en el rango, imprimir
        if (key.compareTo(min) >= 0 && key.compareTo(max) <= 0) {
            System.out.print(key + " ");
        }
        // Si superamos el máximo, ya no necesitamos explorar más claves de este nodo
        if (key.compareTo(max) >= 0) {
            break;
        }
    }
    // Explorar el último hijo posible
    if (i == current.count || current.keys.get(i).compareTo(max) < 0) {
        searchRangeRec(current.childs.get(i), min, max);
    }
}
public void remove(E cl) {
    if (this.root == null) {
        System.out.println("El árbol está vacío");
        return;
    }
    removeRec(this.root, cl);
    
    // Si la raíz se queda vacía tras una fusión, la ajustamos
    if (this.root.count == 0) {
        if (this.root.childs.get(0) == null) {
            this.root = null;
        } else {
            this.root = this.root.childs.get(0);
        }
    }
}


}
