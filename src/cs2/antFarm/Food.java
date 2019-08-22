package cs2.antFarm;

import info.gridworld.actor.Actor;

import java.awt.*;

public abstract class Food extends Actor implements Processable {
    private int biteSize;

    public Food(int bz) {
        biteSize = bz;
    }

    public String toString() {
        return super.toString() + " biteSize is " + biteSize;
    }

    public void act() {
    }

    public void process(WorkerAnt ant) {
        int food = ant.getFood();
        if (food == 0) {
            food = biteSize;
            ant.setFood(food);
            ant.setColor(Color.RED);
        }
        ant.setFoodLoc(this.getLocation());
    }
}
