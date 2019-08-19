package cs2.gridworld;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class MyBug extends Bug {
    public void act() {
        if (canMove())
            move();
        else
            this.setDirection(this.getDirection() + Location.HALF_LEFT);

    }
}
