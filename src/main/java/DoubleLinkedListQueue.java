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
    public DequeNode<T> getAt(int position) { //Initial position = 0
        if(position < this.size() && position >= 0){
            var current = this.peekFirst();
            int pos = 0;
            while(pos < position && current.getNext() != null){
                current = current.getNext();
                pos++;
            }
            return current;
        } else{
            throw new RuntimeException("Invalid position.");
        }
    }

    @Override
    public DequeNode<T> find(T item) {
        var current = first;
        while(current != null){
            if(current.getItem().equals(item)){
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public void delete(DequeNode<T> node) {
        DequeNode<T> actual = first;

        while(actual != null && !actual.equals(node)){
            actual = actual.getNext();
        }
        if(actual!=null){
            DequeNode<T> anterior = actual.getPrevious();
            DequeNode<T> siguiente = actual.getNext();

            if(!actual.isFirstNode()){
                anterior.setNext(siguiente);
            }else{
                this.first=siguiente;
            }
            if(!actual.isLastNode()) {
                siguiente.setPrevious(anterior);
            }else{
                this.last=anterior;
            }
        }

    }

    @Override
    public void sort(Comparator<T> comparator)
    {
        int swapped, i;
        int comparationValue;
        DequeNode<T> ptr1;
        DequeNode<T> lptr = null;
        DequeNode<T> start = first;
        // Checking for empty list
        if (start != null) {

            do {
                swapped = 0;
                ptr1 = start;

                while (ptr1.getNext() != lptr) {
                    comparationValue = comparator.compare(ptr1.getItem(), ptr1.getNext().getItem());

                    if (comparationValue > 0) {
                        T t = ptr1.getItem();
                        ptr1.setItem(ptr1.getNext().getItem());
                        ptr1.getNext().setItem(t);
                        swapped = 1;
                    }
                    ptr1 = ptr1.getNext();
                }
                lptr = ptr1;
            }
            while (swapped != 0);
        }
    }
}
