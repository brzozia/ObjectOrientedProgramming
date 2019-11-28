//package agh.cs.lab2;
package main;

//import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import static java.lang.System.out;
import static java.lang.System.exit;

public class World {

    public static void main(String[] args){

        //f b r l f f r r f f f f f f f f
        try {
            MoveDirection[] directions = new OptionParser().parse(args);
            GrassField map = new GrassField(10);
            map.place(new Animal(map));
            //map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(10, 15)));
            out.println(map.toString());
            map.run(directions);
            out.println(map.toString());
        }
        catch (IllegalArgumentException ex){
            System.out.println("Problem with arguments: " + ex.getMessage());
            exit(1);
        }

    }

}










 /*    old main elements


 Vector2d position1 = new Vector2d(1,2);

        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(position1.toString(position1.x,position1.y));
        System.out.println(position1.toString(position2.x,position2.y));
        if(position1.precedes(position1)==true)
            System.out.println("tak");
        else
            System.out.println("nie");
        Vector2d ala = position1.add(position2);
        System.out.println(ala.toString(ala.x,ala.y));



       MapDirection dir = MapDirection.EAST;
        System.out.println(dir.next());
        System.out.println(dir.previous());
        System.out.println(dir.toStringMap());
        Vector2d dirVector = (dir.toUniVector());
        System.out.println(dirVector.toString(dirVector.x,dirVector.y));

        //Animal lion = new Animal(2,2);
        /*
        System.out.println(lion.toString());
        lion.move(MoveDirection.RIGHT);
        System.out.println(lion.toString());
        lion.move(MoveDirection.FORWARD);
        lion.move(MoveDirection.FORWARD);
        lion.move(MoveDirection.FORWARD);
        //lion.move(MoveDirection.FORWARD);
        System.out.println(lion.toString());

        MoveDirection[] moveTab;
        moveTab=OptionParser.parse(args);

        for(int i=0;i<args.length;i++) {

            if(moveTab[i]!=null) {
                lion.move(moveTab[i]);
                System.out.println(lion.toString());
            }
        }
*/