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
    private DequeNode<Integer> queue;

    @BeforeEach
    public void setup(){ queue = new DequeNode<Integer>(); }
    @AfterEach
    public void finish(){
        queue = null;
    }

    @Test
    public void isFirstNode2_8_nullReturnTrue(){

    }
}