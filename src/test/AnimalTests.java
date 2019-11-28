/*package test;

import main.Animal;
import main.MoveDirection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTests  {


    Animal tiger=new Animal();

    @Test
    void toStringTest(){
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.LEFT);
        assertEquals(tiger.toString(),"vector = (2,3), orient = WEST" );

        tiger.move(MoveDirection.RIGHT);
        tiger.move(MoveDirection.BACKWARD);
        assertEquals(tiger.toString(),"vector = (2,2), orient = NORTH" );
    }
    @Test
    void testMove() {
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        assertEquals(tiger.toString(),"vector = (2,4), orient = NORTH" );

        tiger.move(MoveDirection.LEFT);
        tiger.move(MoveDirection.FORWARD);
        assertEquals(tiger.toString(),"vector = (1,4), orient = WEST" );

        tiger.move(MoveDirection.LEFT);
        tiger.move(MoveDirection.LEFT);
        tiger.move(MoveDirection.RIGHT);
        assertEquals(tiger.toString(),"vector = (1,4), orient = SOUTH" );

        tiger.move(MoveDirection.LEFT);
        tiger.move(MoveDirection.LEFT);
        tiger.move(MoveDirection.RIGHT);
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.BACKWARD);

        assertEquals(tiger.toString(),"vector = (2,4), orient = EAST" );


        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        tiger.move(MoveDirection.FORWARD);
        assertEquals(tiger.toString(),"vector = (4,4), orient = EAST" );
    }
}
*/