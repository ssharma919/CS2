package cs2.antFarm;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

public class ZombieAnt extends Ant{

    private int food;

    public ZombieAnt() {
        this.setColor(Color.GREEN);
        food = 0;
    }

    public void act() {
        ArrayList<Location> arr = this.getGrid().getEmptyAdjacentLocations(this.getLocation());
        int rand = (int) (Math.random() * arr.size());
        this.setDirection(this.getLocation().getDirectionToward(arr.get(rand)));
        this.moveTo(arr.get(rand));
    }

    public void process(WorkerAnt ant){
        if (ant.getFood() != 0) {
            ant.removeSelfFromGrid();
            food++;
        }
    }
}
