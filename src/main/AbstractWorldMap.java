package main;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();

    Vector2d leftDown = new Vector2d(0, 0);
    Vector2d rightUp = leftDown;

    @Override
    public String toString() {
        MapVisualizer mapVis = new MapVisualizer(this);
        return mapVis.draw(leftDown, rightUp);
    }


    public boolean place(Animal animal) {


        if(canMoveTo(animal.getPosition())){
            animals.add(animal);
            animalsMap.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        else {
                throw new IllegalArgumentException(animal.getPosition().toString() + "this place is already occupied!");
            }
        }



    public void run(MoveDirection[] directions) {
        int animalSize = animals.size();
        if (animalSize > 0) {
            for (int i = 0; i < directions.length; i++) {

                animals.get((i % animalSize)).move(directions[i]);

            }
        }
    }


    public boolean isOccupied(Vector2d position) {
        return animalsMap.containsKey(position);
    }


    public Object objectAt(Vector2d position) {
        return animalsMap.get(position); //Returns the value to which the specified key is mapped in this identity hash map, or null if the map contains no mapping for this key.
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animalsMap.put(newPosition, animalsMap.get(oldPosition));
        animalsMap.remove(oldPosition);
    }
}



