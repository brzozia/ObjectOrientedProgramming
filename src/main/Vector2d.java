//package agh.cs.lab2;
package main;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }


    public  String toString(int x,int y){
        return ("("+Integer.toString(x)+","+Integer.toString(y)+")");
    }

    @Override
    public  String toString(){
        return ("("+Integer.toString(x)+","+Integer.toString(y)+")");
    }


    public boolean precedes(Vector2d other){
       return ((this.x <= other.x) && (this.y <= other.y));

    }
    public boolean follows(Vector2d other){
        if((this.x >= other.x) && (this.y >= other.y))
            return true;
        else
            return false;
    }
    public Vector2d upperRight(Vector2d other){
        int a,b;
        if(this.x >= other.x)
            a=this.x;
        else
            a=other.x;

        if(this.y >= other.y)
            b=this.y;
        else
            b=other.y;
        return new Vector2d(a,b);
    }
    public Vector2d lowerLeft(Vector2d other){
        int a,b;
        if(this.x <= other.x)
            a=this.x;
        else
            a=other.x;

        if(this.y <= other.y)
            b=this.y;
        else
            b=other.y;
        return new Vector2d(a,b);
    }
    public Vector2d add(Vector2d other){
        Vector2d vec = new Vector2d(this.x+other.x, this.y+other.y);
        return vec;
    }
    public Vector2d subtract(Vector2d other){
        Vector2d vec = new Vector2d(this.x-other.x, this.y-other.y);
        return vec;
    }
    public boolean equals(Object other){
        if(other == this)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (that.x==this.x &&  that.y==this.y)
            return true;
        else
            return false;
    }
    public Vector2d opposite(){
        return new Vector2d (-1*this.x,-1*this.y);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

}
