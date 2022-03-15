public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{
    DequeNode<T> first = null;
    DequeNode<T> last = null;

    @Override
    public void append(DequeNode<T> node) {
        if(first == null && last == null){ //empty
            first = node;
            last = node;
        } else {
            var oldFirst = first;
            first = node;
            first.setNext(oldFirst);
            oldFirst.setPrevious(first);
        }
    }

    //D ~ A - B - C

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(first == null && last == null){ //empty
            first = node;
            last = node;
        } else if (first == last){ //only 1 element on the deque
            first.setNext(node);
            node.setPrevious(first);
            last = node;
        } else{
            var oldLast = last;
            oldLast.setNext(node);
            last = node;
            last.setPrevious(oldLast);
        }
    }

    @Override
    public void deleteFirst() {
        if(first == null && last == null){
            throw new RuntimeException("List is empty.");
        }

        if(first == last){ //only 1 element
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrevious(null);
        }
    }

    @Override
    public void deleteLast() {
        if(first == null && last == null){
            throw new RuntimeException("List is empty.");
        }

        if(first == last){ //only 1 element
            first = null;
            last = null;
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        return last;
    }

    @Override
    public int size() {
        int size = 0;
        var current = first;
        while(current != null){
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void showList(){
        var current = first;
        if(current != null){
            while(current != null){
                System.out.print(current.getItem() + " ");
                current = current.getNext();
            }
        }
        System.out.println();
    }
}
