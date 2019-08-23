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
        Location nextQ = this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(this.getQueenLoc()));
        Location nextF = this.getLocation().getAdjacentLocation(this.getLocation().getDirectionToward(this.getFoodLoc()));
        if (this.getFood() != 0 && this.getQueenLoc() != null && this.getGrid().isValid(nextQ) == true && this.getGrid().get(nextQ) == null) {
            this.setDirection(this.getLocation().getDirectionToward(nextQ));
            moveTo(nextQ);
        }
        else if (this.getFood() == 0 && this.getFoodLoc() != null && this.getGrid().isValid(nextF) == true && this.getGrid().get(nextF) == null) {
            this.setDirection(this.getLocation().getDirectionToward(nextF));
            moveTo(nextF);
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
}
