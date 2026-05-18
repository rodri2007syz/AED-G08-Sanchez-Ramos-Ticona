package ejercicio4;

public class AVL {

    Nodo raiz;

    // insertar
    Nodo insertar(Nodo n, int dato) {

        if (n == null)
            return new Nodo(dato);

        if (dato < n.dato)
            n.izq = insertar(n.izq, dato);

        else
            n.der = insertar(n.der, dato);

        return n;
    }

    public void insertar(int dato) {

        raiz = insertar(raiz, dato);
    }

    // altura del arbol
    int altura(Nodo n) {

        if (n == null)
            return 0;

        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    // mostrar nivel
    void mostrarNivel(Nodo n, int nivel) {

        if (n == null)
            return;

        if (nivel == 1)
            System.out.print(n.dato + " ");

        else {

            mostrarNivel(n.izq, nivel - 1);
            mostrarNivel(n.der, nivel - 1);
        }
    }

    // recorrido amplitud
    public void amplitud() {

        int h = altura(raiz);

        for (int i = 1; i <= h; i++) {

            mostrarNivel(raiz, i);
        }
    }
}