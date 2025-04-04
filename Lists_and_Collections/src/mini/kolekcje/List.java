package mini.kolekcje;

public class List<T> {

    private class Node<T>{ // klasa wew
        private T data;
        private Node<T> next;
    }

    private Node<T> head;
    private int count;

    public List(){ // konstruktor
        head = null;
        count = 0;
    }

    //interfejs
    public int size(){ //metoda to z malej litery
        return count;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public void pushFront(T data){
        Node<T> n = new Node<>();
        n.data = data;
        n.next = head;
        head = n;
        count++;
    }

    public T firstElement(){
        return head.data;
    }
    public void printList(){
        Node<T> p = head;
        while (!(p == null)){
            System.out.println((p.data + " "));
            p = p.next;
        }
        System.out.println();
    }

    public void pushBack(T data){
        Node n = new Node<>();
        n.data = data;
        n.next = null;
        if (head == null){
            head = n;
        }
        else {
            Node<T> p = head;
            while (p.next != null){
                p = p.next;
            }
            p.next = null;
        }
        count++;
    }

}
