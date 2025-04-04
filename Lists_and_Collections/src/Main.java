import mini.kolekcje.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lista1 = new List<>();
        System.out.println(lista1.isEmpty() ? "lista pusta" : "lista niepusta");
        System.out.println("Ilosc elementow listy: " + lista1.size());
        if (!lista1.isEmpty()) {

            System.out.println("Perwszy element: " + lista1.firstElement());
        }
        lista1.pushFront(3);
        System.out.println(lista1.isEmpty() ? "lista pusta" : "lista niepusta");
        System.out.println("Ilosc elementow listy: " + lista1.size());
        lista1.pushFront(6);
        lista1.pushFront(3);
        lista1.pushFront(2);
        System.out.println("Ilosc elementow listy: " + lista1.size());
        if (!lista1.isEmpty()) {

            System.out.println("Perwszy element: " + lista1.firstElement());
        }
        lista1.printList();
        List<String> lista2 = new List<>();
        System.out.println(lista2.isEmpty() ? "lista pusta" : "lista niepusta");
        System.out.println("Ilosc elementow listy: " + lista2.size());
        lista2.pushFront("kota");
        lista2.pushFront("ma");
        lista2.pushFront("Ala");
    }
}