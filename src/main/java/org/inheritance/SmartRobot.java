package org.inheritance;

public class SmartRobot extends Robot {
    public int counter = 0;

    @Override
    public void moveRight() {
        super.moveRight();
        counter++;
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        counter++;
    }

    @Override
    public void moveUp() {
        super.moveUp();
        counter++;
    }

    @Override
    public void moveDown() {
        super.moveDown();
        counter++;
    }

    public int getStepsCount() {
        return counter;
    }
}

