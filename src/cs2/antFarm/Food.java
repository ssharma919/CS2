package cs2.antFarm;

import info.gridworld.actor.Actor;

public class Food extends Actor {
    private int biteSize;

    public Food(int bz) {
        biteSize = bz;
    }

    public String toString() {
        return super.toString() + " biteSize is " + biteSize;
    }

    public void act() {
    }
}
