package cs2.antFarm;

import info.gridworld.actor.Actor;

public abstract class Ant extends Actor implements Processable {

    private int food;

    public Ant () {
        food = 0;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public String toString() {
        return super.toString() + " food is " + food;
    }

    public void act() {
    }
}
