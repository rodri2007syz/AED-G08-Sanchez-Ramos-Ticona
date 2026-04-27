package actividades;

public class ListLinked<T> {

    Node<T> first;

    public ListLinked(){
        first=null;
    }

    public boolean isEmptyList(){
        return first==null;
    }

    public void insertFirst(T x){

        Node<T> n=
            new Node<T>(x);

        n.next=first;
        first=n;
    }

    public void insertLast(T x){

        Node<T> n=
            new Node<T>(x);

        if(first==null){
            first=n;
        }

        else{

            Node<T> aux=first;

            while(aux.next!=null){
                aux=aux.next;
            }

            aux.next=n;
        }

    }

    public boolean search(T x){

        Node<T> aux=first;

        while(aux!=null){

            if(aux.value.equals(x)){
                return true;
            }

            aux=aux.next;
        }

        return false;
    }

    public boolean removeNode(T x){

        if(first==null){
            return false;
        }

        if(first.value.equals(x)){
            first=first.next;
            return true;
        }

        Node<T> ant=first;
        Node<T> act=first.next;

        while(act!=null){

            if(act.value.equals(x)){
                ant.next=act.next;
                return true;
            }

            ant=act;
            act=act.next;
        }

        return false;
    }

    public int length(){

        int c=0;

        Node<T> aux=first;

        while(aux!=null){
            c++;
            aux=aux.next;
        }

        return c;
    }

    public void print(){

        Node<T> aux=first;

        while(aux!=null){
            System.out.println(aux.value);
            aux=aux.next;
        }

    }

    public void reverse(){

        Node<T> ant=null;
        Node<T> act=first;
        Node<T> sig;

        while(act!=null){

            sig=act.next;
            act.next=ant;
            ant=act;
            act=sig;
        }

        first=ant;
    }

}