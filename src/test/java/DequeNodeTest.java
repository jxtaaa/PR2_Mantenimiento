import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {

    /*
        isFirstNode() para (2, 8, null) es verdadero
        isFirstNode() para (2, 8, 2) es falso
        isFirstNode() para (2, null, null) es verdadero
        isFirstNode() para (2, null, 2) es falso

        getItem() para (null,null,null) devuelve null
        getItem() para (2,null,null) devuelve 2

     */
    private DequeNode<Integer> node;
    // null <-- 2 -> null
    // 2 --> 3
    @BeforeEach
    public void setup(){ node = new DequeNode<Integer>(2, null, null); }
    @AfterEach
    public void finish(){ node = null; }

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
    public void isFirstNode2_null_nullReturnFalse(){
        assertTrue(node.isFirstNode());
    }
    @Test
    public void isFirstNode2_null_2ReturnFalse(){
        DequeNode<Integer> node1 = new DequeNode<Integer>(2, null, node);
        assertFalse(node1.isFirstNode());
    }

    @Test
    public void getItemnull_null_nullReturn(){
        assertNull(new DequeNode<Integer>(null, null, null).getItem());
    }
    @Test
    public void getItem2_null_nullReturn(){
        assertEquals(2, node.getItem());
    }
}