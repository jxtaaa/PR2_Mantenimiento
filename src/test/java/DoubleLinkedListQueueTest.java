import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListQueueTest {

    private DoubleLinkedListQueue<Integer> list;

    @BeforeEach
    public void setup(){ list = new DoubleLinkedListQueue<>();}
    @AfterEach
    public void finish(){ list = null; }

    @Test
    public void AppendOnEmptyListShoudReturnFirst(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.first, node);
    }

    @Test
    public void AppendOnEmptyListShoudReturnLast(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.last, node);
    }

    @Test
    public void AppendOnNotEmptyListShouldReturnFirst(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        list.append(node);
        list.append(node1);
        assertEquals(list.first, node1);
    }

    @Test
    public void AppendOnNotEmptyListShouldReturnLast(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        list.append(node);
        list.append(node1);
        assertEquals(list.last, node);
    }

    @Test
    public void AppendLeftOnEmptyListShoudReturnFirst(){
        var node = new DequeNode<>(2,null,null);
        list.appendLeft(node);
        assertEquals(list.first, node);
    }

    @Test
    public void AppendLeftOnEmptyListShoudReturnLast(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.last, node);
    }

    @Test
    public void AppendLeftOnNotEmptyListShouldReturnFirstAppended(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        assertEquals(list.first, node);
    }

    @Test
    public void AppendLeftOnNotEmptyListShouldReturnLastAppended(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        assertEquals(list.last, node1);
    }

    @Test
    public void AppendLeftOnNotEmptyListShouldReturnFirst_1(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        var node2 = new DequeNode<>(4,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        list.appendLeft(node2);
        assertEquals(list.first, node);
    }

    @Test
    public void AppendLeftOnNotEmptyListShouldReturnLast_1(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        var node2 = new DequeNode<>(4,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        list.appendLeft(node2);
        assertEquals(list.last, node2);
    }

    @Test
    public void DeleteFirstOnEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.deleteFirst());
    }

    @Test
    public void DeleteLastOnEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.deleteLast());
    }

    @Test
    public void DeleteFirstOnNotEmptyListShouldHaveFirstNull(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        list.deleteFirst();
        assertNull(list.first);
    }

    @Test
    public void DeleteFirstOnNotEmptyListShouldHaveLastNull(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        list.deleteLast();
        assertNull(list.last);
    }

    @Test
    public void DeleteFirstOnNotEmptyListShouldHaveFirstDistinct(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        var node2 = new DequeNode<>(4,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        list.appendLeft(node2);
        list.deleteFirst();
        assertEquals(list.first, node1);
    }

    @Test
    public void DeleteLastOnNotEmptyListShouldHaveFirstDistinct(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        var node2 = new DequeNode<>(4,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        list.appendLeft(node2);
        list.deleteLast();
        assertEquals(list.last, node1);
    }

    @Test
    public void FirstOnEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.peekFirst());
    }

    @Test
    public void LastOnEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.peekLast());
    }

    @Test
    public void FirstOnNotEmptyShouldReturnFirstElement(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.peekFirst(), node);
    }

    @Test
    public void LastOnNotEmptyShouldReturnFirstElement(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.peekLast(), node);
    }

    @Test
    public void getAtWithValidPositionShouldReturnElementAtPosition(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        var node2= new DequeNode<>(4,null,null);

        list.append(node);
        list.append(node1);
        list.append(node2);

        assertEquals(list.getAt(2), node);
    }

    @Test
    public void getAtWithInvalidPositionOrEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.getAt(-1));
    }


    @Test
    public void getAtWithLatestPositionShouldReturnLastNode(){
        for(int i = 0; i < 10; i ++){
            DequeNode<Integer> n = new DequeNode<>(i,null,null);
            list.appendLeft(n);
        }

        assertEquals(list.getAt(9),list.peekLast());
    }

    @Test
    public void findAnElementThatBelongsToListReturnsThatElement(){
        for(int i = 0; i < 10; i ++){
            DequeNode<Integer> n = new DequeNode<>(i,null,null);
            list.appendLeft(n);
        }

        assertEquals(list.find(9),list.peekLast());
    }

    @Test
    public void findAnElementThatDoesNotBelongToListReturnsNull(){
        for(int i = 0; i < 10; i ++){
            DequeNode<Integer> n = new DequeNode<>(i,null,null);
            list.appendLeft(n);
        }

        assertNull(list.find(45));
    }

    @Test
    public void findAnElementOnAListThatIsEmptyReturnsNull(){
        assertNull(list.find(1));
    }

    
}
