import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    // null <-- 2 --> 3
    // 2 --> 3
    /*
    Siendo (item, next, previous)

        setItem(3) establece a 3 item
        setItem(null) establece a null item

        setPrevious(Node(2,null,null)) establece el anterior a Node(2,null,null)
        setPrevious(null) establece el anterior a null

        setNext(Node(2,null,null)) establece el siguiente a Node(2,null,null)
        setNext(null) establece el siguiente a null

        isNotATerminalNode() para (2,2,2) es verdadero
        isNotATerminalNode() para (2,null,2) es falso
        isNotATerminalNode() para (2,2,null) es falso
        isNotATerminalNode() para (2,null,null) es falso

        isFirstNode() para (2, 8, null) es verdadero
        isFirstNode() para (2, 8, 2) es falso
        isFirstNode() para (2, null, null) es verdadero
        isFirstNode() para (2, null, 2) es falso

        isLastNode() para (2,null,null) es verdadero
        isLastNode() para (2,3,null) es falso
        isLastNode() para (2,3,4) es falso
        isLastNode() para (2,null,4) es verdadero

        getItem() para (null,null,null) devuelve null
        getItem() para (2,null,null) devuelve 2

        getNext() para (1, 2, 3) devuelve nodo2
        getNext() para (1, 23, null) devuelve nodo23
        getNext() para (0, null, null) devuelve null

        getPrevious() para (2,2,null) devuelve null
        getPrevious() para (2,null,3) devuelve 3
     */
    private DequeNode<Integer> node;

    @BeforeEach
    public void setup(){ node = new DequeNode<Integer>(2, null, null); }
    @AfterEach
    public void finish(){ node = null; }

    @Test
    public void setItem3(){
        node.setItem(3);
        assertEquals(3, node.getItem());
    }
    @Test
    public void setItemnull(){
        node.setItem(null);
        assertNull(node.getItem());
    }
    @Test
    public void setNextNode1(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, null);
        node.setNext(node1);

        assertEquals(node1, node.getNext());
    }
    @Test
    public void setNextNull(){
       node.setNext(null);

        assertNull(node.getNext());
    }
    @Test
    public void setPreviousNode1(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, null);
        node.setPrevious(node1);

        assertEquals(node1, node.getPrevious());
    }
    @Test
    public void setPreviousNull(){
        node.setPrevious(null);

        assertNull(node.getPrevious());
    }
    @Test
    public void isNotATerminalNodeNode2_2_2ReturnTrue(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, node);
        DequeNode<Integer> node2 = new DequeNode<Integer>(2, null, node1);
        assertTrue(node1.isNotATerminalNode());
    }
    @Test
    public void isNotATerminalNodeNode2_null_2ReturnTrue(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, node);

        assertFalse(node1.isNotATerminalNode());
    }
    @Test
    public void isNotATerminalNodeNode2_2_nullReturnTrue(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, node);

        assertFalse(node.isNotATerminalNode());
    }
    @Test
    public void isNotATerminalNodeNode2_null_nullReturnTrue(){

        assertFalse(node.isNotATerminalNode());
    }
    @Test
    public void isFirstNode2_8_nullReturnTrue(){
        new DequeNode<Integer>(8, null, node);
        assertTrue(node.isFirstNode());
    }

    @Test
    public void isFirstNode2_8_2ReturnFalse(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, node);
        new DequeNode<>(8, null, node1);
        assertFalse(node1.isFirstNode());
    }

    @Test
    public void isFirstNode2_null_nullReturnTrue(){
        assertTrue(node.isFirstNode());
    }
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
}