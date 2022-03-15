public class Main {
    public static void main(String[] args) {
        DoubleLinkedListQueue<Integer> list = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n1 = new DequeNode<>(1,null,null);
        DequeNode<Integer> n2 = new DequeNode<>(2,null,null);
        for(int i = 0; i < 10; i ++){
            System.out.println("Añadimos " + i);
            DequeNode<Integer> n = new DequeNode<>(i,null,null);
            list.appendLeft(n);
        }

        System.out.println("First: " + list.first.getItem());
        System.out.println("Last: " + list.last.getItem());
        System.out.print("List: "); list.showList();

        list.deleteFirst();
        list.showList();
        list.deleteLast();
        list.showList();
        System.out.println("Size: " + list.size());
    }
}
