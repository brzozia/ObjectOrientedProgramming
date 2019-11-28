package test;
import main.*;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTests{
    GrassField grass = new GrassField(10);
    RectangularMap map=new RectangularMap(10,10);
    String[] strDirections={"f", "b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
    MoveDirection[] directions = new OptionParser().parse(strDirections);
    Vector2d catPos = new Vector2d(0,0);
    Vector2d dogPos = new Vector2d(50,50);
    Animal testCat = new Animal(map,catPos);
    Animal testCatClone = new Animal(map,catPos);
    Animal testDog = new Animal(map,dogPos);

    @Test
    void canMoveToTest(){

        for(Grass ele : grass.grassFields){
            if(grass.objectAt(ele.getPosition()) instanceof Grass)
            assertTrue(grass.canMoveTo(ele.getPosition()));
        }
    }

    @Test
    void placeTest(){

        assertTrue(grass.place(testCat));
        assertTrue(grass.place(testDog));
       // assert(grass.place(testCatClone));
    }

    @Test
    void isOccupiedTest(){
        grass.place(testCat);
        assertTrue(grass.isOccupied(catPos));
        grass.place(testDog);
        assertTrue(grass.isOccupied(dogPos));

        for(Grass ele : grass.grassFields){
            assertTrue(grass.isOccupied(ele.getPosition()));
        }
    }

    @Test
    void runTest(){
        grass.place(testCat);
        assertTrue(grass.isOccupied(catPos));
        grass.run(directions);
        assertTrue(grass.isOccupied( new Vector2d(0,0)));
    }

    @Test
    void objectAt(){
        for(Grass ele : grass.grassFields){
            assertTrue(grass.objectAt(ele.getPosition()) instanceof Grass);

//            grass.place(testCat);
//            assertTrue(grass.objectAt(catPos) instanceof Animal);
        }
    }
}
