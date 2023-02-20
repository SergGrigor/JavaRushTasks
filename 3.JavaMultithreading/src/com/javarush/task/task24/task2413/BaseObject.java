package com.javarush.task.task24.task2413;

public abstract class BaseObject {

    protected double x;
    protected double y;
    protected double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract public void draw(Canvas canvas);
    abstract public void move();

    public boolean intersects(BaseObject o) {
         if (Math.hypot(Math.pow((o.x - this.x), 2.0), Math.pow((o.y - this.y), 2.0)) <= Math.max(this.radius, o.radius)) {
             return true;
         }
        return false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
