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
    public void AppendLeftOnNotEmptyListShouldReturnFirst(){
        var node = new DequeNode<>(2,null,null);
        var node1 = new DequeNode<>(3,null,null);
        list.appendLeft(node);
        list.appendLeft(node1);
        assertEquals(list.first, node);
    }

    @Test
    public void AppendLeftOnNotEmptyListShouldReturnLast(){
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
    public void deleteFirstOnEmptyListShouldThrowException(){
        assertThrows(RuntimeException.class, () -> list.deleteFirst());
    }

    @Test
    public void deleteLastOnEmptyListShouldThrowException(){
        assertThrows(RuntimeException.class, () -> list.deleteLast());
    }

    @Test
    public void deleteFirstOnNotEmptyListShouldHaveFirstNull(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        list.deleteFirst();
        assertNull(list.first);
    }

    @Test
    public void deleteFirstOnNotEmptyListShouldHaveLastNull(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        list.deleteLast();
        assertNull(list.last);
    }

    @Test
    public void deleteFirstOnNotEmptyListShouldHaveFirstDistinct(){
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
    public void deleteLastOnNotEmptyListShouldHaveFirstDistinct(){
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
    public void firstOnEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.peekFirst());
    }

    @Test
    public void lastOnEmptyListShouldThrowRuntimeException(){
        assertThrows(RuntimeException.class, () -> list.peekLast());
    }

    @Test
    public void firstOnNotEmptyShouldReturnFirstElement(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.peekFirst(), node);
    }

    @Test
    public void lastOnNotEmptyShouldReturnFirstElement(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        assertEquals(list.peekLast(), node);
    }

    @Test
    public void showEmptyListShowsEmptyList(){
        list.showList();
    }

    @Test
    public void showListShowsList(){
        var node = new DequeNode<>(2,null,null);
        list.append(node);
        list.showList();
    }

    /*
    @Test
    public void isFirstNode2_null_2ReturnFalse(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, node);
        assertFalse(node1.isFirstNode());
    }
    @Test
    public void isLastNode2_null_nullReturnTrue(){
        assertTrue(node.isLastNode());
    }
    @Test
    public void isLastNode2_3_nullReturnFalse(){
        DequeNode<Integer> node3 = new DequeNode<Integer>(3, null, node);
        assertFalse(node.isLastNode());
    }
    @Test
    public void isLastNode2_3_4ReturnFalse(){
        DequeNode<Integer> node4 = new DequeNode<Integer>(3, null, null);
        DequeNode<Integer> node2 = new DequeNode<Integer>(3, null, node4);
        DequeNode<Integer> node3 = new DequeNode<Integer>(3, null, node2);

        assertFalse(node2.isLastNode());
    }
    @Test
    public void isLastNode2_null_4ReturnTrue(){
        DequeNode<Integer> node4 = new DequeNode<Integer>(3, null, null);
        DequeNode<Integer> node2 = new DequeNode<Integer>(2, null, node4);
        assertTrue(node2.isLastNode());
    }
    @Test
    public void getItemnull_null_nullReturnNull(){
        assertNull(new DequeNode<Integer>(null, null, null).getItem());
    }

    @Test
    public void getItem2_null_nullReturn2(){
        assertEquals(2, node.getItem());
    }

    @Test
    public void getNext1_2_3ReturnNode3(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<Integer>(2, null, node1);
        DequeNode<Integer> node3 = new DequeNode<Integer>(3, null, node2);

        assertEquals(node3, node2.getNext());
    }

    @Test
    public void getNext1_23_nullReturnNode2(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<Integer>(23, null, node1);

        assertEquals(node2, node1.getNext());
    }

    @Test
    public void getNext0_null_nullReturnNull(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(0, null, null);

        assertNull(node1.getNext());
    }

    @Test
    public void getPrevious2_null_nullReturnnull(){
        assertNull(node.getPrevious());
    }

    @Test
    public void getPrevious2_null_2ReturnNode2(){
        DequeNode<Integer> node2 = new DequeNode<Integer>(2, null, node);

        assertEquals(node ,node2.getPrevious());
    }

     */

}