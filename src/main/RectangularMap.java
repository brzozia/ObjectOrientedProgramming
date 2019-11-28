package main;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    int width;;
    int height;


    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString(){
        leftDown = new Vector2d(0,0);
        rightUp = new Vector2d(this.width, this.height);

        return super.toString();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        Vector2d pre = new Vector2d(this.width,this.height);
        Vector2d foll = new Vector2d(0,0);

        if((!isOccupied(position)) && (position.precedes(pre)) && (position.follows(foll)))
            return true;
        else
            return false;
    }
}









/*
    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition()))
            return false;
        else{
            animals.add(animal);
            return true;
        }

    }

    @Override
    public void run(MoveDirection[] directions) {
        int animalSize = animals.size();
        if (animalSize > 0) {
            for (int i = 0; i < directions.length; i++) {
                animals.get(i % animalSize).move(directions[i]);
            }
        }
    }



    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal cat: animals){
            if(cat.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal cat :animals){
            if(cat.getPosition().equals(position))
                return cat;
        }
        return null;
    }

*/