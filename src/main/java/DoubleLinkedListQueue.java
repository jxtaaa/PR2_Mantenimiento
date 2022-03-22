import java.util.Comparator;

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
        if( size() == 0){
            throw new RuntimeException("Empty list.");
        }
        return first;
    }

    @Override
    public DequeNode<T> peekLast() {
        if( size() == 0){
            throw new RuntimeException("Empty list.");
        }
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

    @Override
    public DequeNode<T> getAt(int position) {
        return null;
    }

    @Override
    public DequeNode<T> find(T item) {
        return null;
    }

    @Override
    public void delete(DequeNode<T> node) {

    }

    @Override
    public void sort(Comparator<?> comparator) {

    }
}
