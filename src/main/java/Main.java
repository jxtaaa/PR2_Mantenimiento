public class Main {
    public static void main(String[] args) {
        DoubleLinkedListQueue<Integer> list = new DoubleLinkedListQueue<>();
        DequeNode<Integer> n1 = new DequeNode<>(1,null,null);
        DequeNode<Integer> n3 = new DequeNode<>(5,null,null);
        DequeNode<Integer> n4 = new DequeNode<>(2,null,null);
        DequeNode<Integer> n5 = new DequeNode<>(8,null,null);
        DequeNode<Integer> n6 = new DequeNode<>(4,null,null);
        DequeNode<Integer> n7 = new DequeNode<>(3,null,null);
        DequeNode<Integer> n8 = new DequeNode<>(7,null,null);
        DequeNode<Integer> n9 = new DequeNode<>(9,null,null);

        list.appendLeft(n1);
        list.appendLeft(n3);
        list.appendLeft(n4);
        list.appendLeft(n5);
        list.appendLeft(n6);
        list.appendLeft(n7);
        list.appendLeft(n8);
        list.appendLeft(n9);


        System.out.println("First: " + list.first.getItem());
        System.out.println("Last: " + list.last.getItem());
        System.out.println("Size: " + list.size());

        System.out.println("Item at pos: " + list.getAt(7).getItem());

        System.out.println("Finding item 9: " + list.find(5).getItem());

        list.sort(Integer::compare);

        var fist = list.first;
    }
}
