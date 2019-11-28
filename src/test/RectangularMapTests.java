
package test;

import main.OptionParser;
import main.MoveDirection;
import main.RectangularMap;
import main.Vector2d;
import main.IWorldMap;
import main.Animal;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTests {
    String[] strDirections={"f", "b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
    MoveDirection[] directions = new OptionParser().parse(strDirections);
    String[] strDirSecond={"f","f","r", "r","f","f"};
    MoveDirection[] dirSecond = new OptionParser().parse(strDirSecond);
    String[] strDirThird={"r","r","r", "f","f","f","f","f","f","f","f","f","f","f","f"};
    MoveDirection[] dirThird = new OptionParser().parse(strDirThird);

    IWorldMap map = new RectangularMap(10,5);
    Vector2d initPos1=new Vector2d(2,3);
    Vector2d initPos2=new Vector2d(10,5);
    Animal dog = new Animal(map,initPos1);
    Animal fox = new Animal(map, initPos2);
    Vector2d initPos3=new Vector2d(20,20);
    Animal an = new Animal(map,initPos2);



    @Test
    void canMoveToTest(){
        assertTrue(map.canMoveTo(new Vector2d(5, 3)));
        assertFalse(map.canMoveTo(new Vector2d(-1, 2)));
        assertFalse(map.canMoveTo(new Vector2d(1, -2)));
        assertFalse(map.canMoveTo(new Vector2d(5, 6)));
        assertFalse(map.canMoveTo(new Vector2d(11, 2)));
    }

    @Test
    void integrityTest(){
        assertTrue(map.place(dog));
        if(!map.isOccupied(fox.getPosition()))
            map.place(fox);
            //map.place(dog);

        assertTrue(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.isOccupied(new Vector2d(10,5)));

        map.run(dirSecond);
        assertTrue(map.isOccupied( new Vector2d(3,4)));
        assertTrue(map.isOccupied( new Vector2d(10,5)));

        assertEquals(dog.toString(),"E");
        assertEquals(fox.toString(),"E");

        map.run(dirThird);
        assertTrue(map.isOccupied( new Vector2d(0,4)));
        assertTrue(map.isOccupied( new Vector2d(10,0)));

        assertEquals(map.objectAt(new Vector2d(0,4)), dog);
        assertEquals(map.objectAt(new Vector2d(10,0)), fox);

        assertFalse(map.isOccupied( new Vector2d(3,4)));
        assertFalse(map.isOccupied( new Vector2d(10,5)));

        map.run(directions);
        assertTrue(map.isOccupied( new Vector2d(4,5)));
        assertTrue(map.isOccupied( new Vector2d(10,0)));

        assertEquals(dog.toString(),"E");
        assertEquals(fox.toString(),"S");

        assertThrows(IllegalArgumentException.class,() ->{map.place(fox);map.place(an);});

    }


}
