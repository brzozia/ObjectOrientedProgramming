package test;
import org.junit.jupiter.api.Test;
import main.Vector2d;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void testEquals(){
        assertEquals(new Vector2d(1,1), new Vector2d(1,1));
    }

    Vector2d v1 = new Vector2d(1,1);
    Vector2d v2 = new Vector2d(2,3);
    @Test
    void testToString(){
        assertEquals(v1.toString(v1.x,v1.y), "(1,1)");
    }

    @Test
    void testPrecedes(){
        assertTrue(v1.precedes(v2) );
        assertFalse(v2.precedes(v1) );
    }
    @Test
    void testFollows(){
        assertFalse(v1.follows(v2) );
        assertTrue(v2.follows(v1) );
    }
    @Test
    void testUpperRight(){
        assertEquals(v1.upperRight(v2), v2);
    }
    Vector2d v3=new Vector2d(1,4);

    @Test
    void testLowerLeft(){
        assertEquals(v2.lowerLeft(v3), new Vector2d(1,3));
    }
    @Test
    void testAdd(){
        assertEquals(v1.add(v2), new Vector2d(3,4));
    }
    @Test
    void testSubtract(){
        assertEquals(v2.subtract(v1), new Vector2d(1,2));
    }
    @Test
    void testOpposite(){
        assertEquals(v2.opposite(), new Vector2d(-2,-3));
    }
}
