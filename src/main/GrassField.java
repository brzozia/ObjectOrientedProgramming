package main;

import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassField extends AbstractWorldMap {
    public int noOfGrass;
    public List<Grass> grassFields = new ArrayList<>();
    protected Map<Vector2d, Grass> grassMap = new HashMap<>();
    public  MapBoundary bMap = new MapBoundary();

    @Override
    public boolean place(Animal fox){
        if(super.place(fox)) {
            fox.addObserver(bMap);
            bMap.addElement(fox.getPosition());
            return true;
        }
        return false;
    }

    public GrassField(int noOfGrass){
        int x= (int) Math.sqrt(noOfGrass*10);

         for(int i=noOfGrass;i>0;i--){

             Vector2d randPos=new Vector2d((int) (Math.random()*x +1), (int) (Math.random()*x +1));
             Grass randGrass=new Grass(randPos);

             if(!(objectAt(randPos) instanceof Grass)) {
                grassFields.add(randGrass);
                bMap.addElement(randPos);
                grassMap.put(randPos, randGrass);
             }
             else{
                 i++;
             }
         }
     };

    @Override
    public String toString(){
        if(!grassFields.isEmpty()){
            leftDown=grassFields.get(0).getPosition();
            rightUp =grassFields.get(0).getPosition();
        }
        leftDown = bMap.getLeftDown();
        rightUp= bMap.getRightUp();

        return  super.toString();

    }


    public boolean canMoveTo(Vector2d position) {
        if(!(objectAt(position) instanceof Animal))
            return true;
        else
            return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if(super.isOccupied(position) == true)
            return super.isOccupied(position);

        return grassMap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(super.objectAt(position) != null)
            return super.objectAt(position);

        return grassMap.get(position);

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
        for(Grass flower : grassFields){
            if(flower.getPosition().equals(position))
                return true;
        }
        for(Animal cat: animals){
            if(cat.getPosition().equals(position))
                return true;
        }
        return false;
        //return !objectAt(position).equals(null);
    }


    public Object objectAt(Vector2d position) {
        for(Grass flower : grassFields){
            if(flower.getPosition().equals(position))
                return flower;
        }
        for(Animal cat: animals){
            if(cat.getPosition().equals(position))
                return cat;
        }
        return null;
    }

     */