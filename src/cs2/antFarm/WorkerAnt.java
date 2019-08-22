package cs2.antFarm;

import info.gridworld.actor.Actor;

import javax.xml.stream.Location;
import java.awt.*;
import java.util.ArrayList;

public class WorkerAnt extends Ant {

    public WorkerAnt() {
        setColor(Color.BLACK);
    }

//    public void act() {
//        ArrayList<Location> arr = this.getGrid().getEmptyAdjacentLocations(this.getLocation());
//        int rand = (int) (Math.random()*arr.size());
//        this.moveTo(arr.get(rand));
//        this.setDirection(this.getLocation().getDirectionToward(arr.get(rand)));
//    }
}
