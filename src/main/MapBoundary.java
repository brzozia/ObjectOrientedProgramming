package main;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private Comparator<Vector2d> xComparator = Comparator.comparingInt(v->v.x);
    private Comparator<Vector2d> yComparator = Comparator.comparingInt(o->o.y);

    private SortedSet<Vector2d> xs = new TreeSet<>(xComparator);
    private SortedSet<Vector2d> ys = new TreeSet<>(yComparator);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xs.remove(oldPosition);
        ys.remove(oldPosition);
        xs.add(newPosition);
        ys.add(newPosition);
    }

    public void addElement(Vector2d position){
        xs.add(position);
        ys.add(position);
    }

    public void removeElement(Vector2d position){
        xs.remove(position);
        ys.remove(position);
    }

    public Vector2d getLeftDown(){
        return xs.first().lowerLeft(ys.first());
    }

    public Vector2d getRightUp(){
        return xs.last().upperRight(ys.last());
    }
}
