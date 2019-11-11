package com.lobach;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = this.x1 + width;
        this.y2 = this.y1 + height;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getWight() {
        return x2;
    }

    public int getHeight() {
        return y2;
    }

    public boolean collides(Ball ball) {
        boolean i = false;
        if (ball.getX() >= x1 + getWight() - ball.getRadius() || ball.getX() <= x1 + ball.getRadius()) i = true;
        if (ball.getX() >= y1 + getWight() - ball.getRadius() || ball.getX() <= y1 + ball.getRadius()) i = true;
        return i;
    }

    @Override
    public String toString() {
        return "Container[" +
                "(" + x1 +
                ", " + y1 + "), (" + x2 + " ," + y2 + ")" +
                ']';
    }
}
