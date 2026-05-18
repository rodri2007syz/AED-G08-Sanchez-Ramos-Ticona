package ejercicio3;

public class AVLTree {

    Nodo raiz;

    // altura
    int altura(Nodo n) {

        if (n == null)
            return 0;

        return n.altura;
    }

    // balance
    int balance(Nodo n) {

        if (n == null)
            return 0;

        return altura(n.der) - altura(n.izq);
    }

    // actualizar altura
    void actualizarAltura(Nodo n) {

        n.altura = 1 + Math.max(altura(n.izq), altura(n.der));
    }

    // rotacion izquierda
    Nodo rotarIzq(Nodo x) {

        Nodo y = x.der;
        Nodo temp = y.izq;

        y.izq = x;
        x.der = temp;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // rotacion derecha
    Nodo rotarDer(Nodo y) {

        Nodo x = y.izq;
        Nodo temp = x.der;

        x.der = y;
        y.izq = temp;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // insertar
    Nodo insertar(Nodo n, int dato) {

        if (n == null)
            return new Nodo(dato);

        if (dato < n.dato)
            n.izq = insertar(n.izq, dato);

        else if (dato > n.dato)
            n.der = insertar(n.der, dato);

        actualizarAltura(n);

        int bf = balance(n);

        // izquierda izquierda
        if (bf < -1 && dato < n.izq.dato)
            return rotarDer(n);

        // derecha derecha
        if (bf > 1 && dato > n.der.dato)
            return rotarIzq(n);

        // izquierda derecha
        if (bf < -1 && dato > n.izq.dato) {

            n.izq = rotarIzq(n.izq);
            return rotarDer(n);
        }

        // derecha izquierda
        if (bf > 1 && dato < n.der.dato) {

            n.der = rotarDer(n.der);
            return rotarIzq(n);
        }

        return n;
    }

    public void insertar(int dato) {

        raiz = insertar(raiz, dato);
    }

    // menor valor
    Nodo minValor(Nodo n) {

        Nodo actual = n;

        while (actual.izq != null)
            actual = actual.izq;

        return actual;
    }

    // eliminar
    Nodo eliminar(Nodo n, int dato) {

        if (n == null)
            return n;

        if (dato < n.dato)
            n.izq = eliminar(n.izq, dato);

        else if (dato > n.dato)
            n.der = eliminar(n.der, dato);

        else {

            if (n.izq == null || n.der == null) {

                Nodo temp;

                if (n.izq != null)
                    temp = n.izq;

                else
                    temp = n.der;

                if (temp == null)
                    n = null;

                else
                    n = temp;
            }

            else {

                Nodo temp = minValor(n.der);

                n.dato = temp.dato;

                n.der = eliminar(n.der, temp.dato);
            }
        }

        if (n == null)
            return n;

        actualizarAltura(n);

        int bf = balance(n);

        // izquierda izquierda
        if (bf < -1 && balance(n.izq) <= 0)
            return rotarDer(n);

        // izquierda derecha
        if (bf < -1 && balance(n.izq) > 0) {

            n.izq = rotarIzq(n.izq);
            return rotarDer(n);
        }

        // derecha derecha
        if (bf > 1 && balance(n.der) >= 0)
            return rotarIzq(n);

        // derecha izquierda
        if (bf > 1 && balance(n.der) < 0) {

            n.der = rotarDer(n.der);
            return rotarIzq(n);
        }

        return n;
    }

    public void eliminar(int dato) {

        raiz = eliminar(raiz, dato);
    }

    // inorden
    void inorden(Nodo n) {

        if (n != null) {

            inorden(n.izq);
            System.out.print(n.dato + " ");
            inorden(n.der);
        }
    }

    public void mostrar() {

        inorden(raiz);
        System.out.println();
    }
}