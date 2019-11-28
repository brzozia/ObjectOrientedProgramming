package main;

import java.util.LinkedList;
import java.util.List;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orient = MapDirection.NORTH;
    private IWorldMap map;
    protected List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map){
        this.map=map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
       this.map=map;
       this.position=initialPosition;
    }

    public Vector2d getPosition(){
        return position;
    }


    public String toString() {
        String result = null;
        switch (orient) {
             case NORTH:
                 result = "N";
                 break;
            case SOUTH:
                result = "S";
                break;
            case WEST:
                result = "W";
                break;
            case EAST:
                result = "E";
                break;
        }
        return result;
    }

    public void move(MoveDirection direction){
        Vector2d newPosition = position;
        switch(direction){
            case RIGHT:
                orient = orient.next();
                break;
            case LEFT:
                orient = orient.previous();
                break;
            case FORWARD:
                newPosition = this.position.add(this.orient.toUniVector());
                break;
            case BACKWARD:
                newPosition = this.position.subtract(this.orient.toUniVector());
                break;

        }

        if(map.canMoveTo(newPosition)){
            positionChanged(newPosition, position);
            this.position=newPosition;
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Vector2d newPosition, Vector2d oldPosition){
        for(IPositionChangeObserver s: observers){
            s.positionChanged(oldPosition, newPosition);
        }
    }
}
