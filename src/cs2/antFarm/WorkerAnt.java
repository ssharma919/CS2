package cs2.antFarm;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


import java.awt.*;
import java.util.ArrayList;

public class WorkerAnt extends Ant {

    private Location queenLoc;
    private Location foodLoc;

    public Location getQueenLoc() {
        return queenLoc;
    }

    public void setQueenLoc(Location queenLoc) {
        this.queenLoc = queenLoc;
    }

    public Location getFoodLoc() {
        return foodLoc;
    }

    public void setFoodLoc(Location foodLoc) {
        this.foodLoc = foodLoc;
    }

    public WorkerAnt() {
        setColor(Color.BLACK);
    }

    public void act() {
        if (this.getQueenLoc() != null) {
            Location next = selectMoveLocation(this);
            if (this.getGrid().get(next) == null && this.getGrid().isValid(next) == true) {
                if (this.getFood() != 0) {
                    this.setDirection(this.getLocation().getDirectionToward(next));
                    moveTo(next);
                } else if (this.getFood() == 0 && this.getFoodLoc() != null) {
                    this.setDirection(this.getLocation().getDirectionToward(next));
                    moveTo(next);
                }
            }
        }
        else {
            ArrayList<Location> arr = this.getGrid().getEmptyAdjacentLocations(this.getLocation());
            int rand = (int) (Math.random() * arr.size());
            this.setDirection(this.getLocation().getDirectionToward(arr.get(rand)));
            this.moveTo(arr.get(rand));
        }
        ArrayList<Actor> arrAct = this.getGrid().getNeighbors(this.getLocation());
        for (int i = 0; i < arrAct.size(); i++) {
            ((Processable)(arrAct.get(i))).process(this);
        }
    }

    public void process(WorkerAnt ant) {
        if (ant.getFoodLoc() == null) ant.setFoodLoc(this.getFoodLoc());
        if (ant.getQueenLoc() == null) ant.setQueenLoc(this.getQueenLoc());
    }

    public String toString() {
        return super.toString() + "foodLoc " + foodLoc + "queenLoc " + queenLoc;
    }

    private static Location selectMoveLocation(WorkerAnt ant) {
        int rand = (int)(Math.random()*3);
        ArrayList<Integer> arr = new ArrayList<>();
        if (ant.getQueenLoc() != null && ant.getFood() != 0) {
            arr.add(ant.getLocation().getDirectionToward(ant.queenLoc));
            arr.add(ant.getLocation().getDirectionToward(ant.queenLoc) + Location.HALF_LEFT);
            arr.add(ant.getLocation().getDirectionToward(ant.queenLoc) + Location.HALF_RIGHT);
            return ant.getLocation().getAdjacentLocation(arr.get(rand));
        } else if (ant.getFoodLoc() != null){
            arr.add(ant.getLocation().getDirectionToward(ant.foodLoc));
            arr.add(ant.getLocation().getDirectionToward(ant.foodLoc) + Location.HALF_LEFT);
            arr.add(ant.getLocation().getDirectionToward(ant.foodLoc) + Location.HALF_RIGHT);
            return ant.getLocation().getAdjacentLocation(arr.get(rand));
        }
        return ant.getLocation();
    }
}
