package cs2.maze;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Stack;

public class Mouse extends Actor {

    private Stack<Location> stack;
    private Stack<Location> stackNull;
    private Location nextLoc;
    private Location oldLoc;
    private Location checkLoc;

    public Mouse () {
        stack = new Stack<>();
        stackNull = new Stack<>();
        nextLoc = null;
        oldLoc = null;
        checkLoc = null;
    }

    public void act() {
        if (findCheese() != null) {
            return;
        }
        else {
            ArrayList<Location> list = this.getLocs();
            for (int i = 0; i < list.size(); i++) {
                stack.push(list.get(i));
                stackNull.push(list.get(i));
                if (list.size() > 1)
                    stackNull.push(null);
            }
            checkLoc = stackNull.pop();
            if (checkLoc == null) {
                nextLoc = findBreadcrumb();
                oldLoc = this.getLocation();
                this.setDirection(this.getLocation().getDirectionToward(nextLoc));
                moveTo(nextLoc);
                this.getGrid().put(oldLoc, new Breadcrumb());
            }
            else {
                nextLoc = stack.pop();
                oldLoc = this.getLocation();
                this.setDirection(this.getLocation().getDirectionToward(nextLoc));
                moveTo(nextLoc);
                this.getGrid().put(oldLoc, new Breadcrumb());
            }
        }
    }

    private Location findCheese() {
        int dir = 0;
        for (int i = 0; i < 4; i++) {
            if (this.getGrid().isValid(this.getLocation().getAdjacentLocation(dir)) && this.getGrid().get(this.getLocation().getAdjacentLocation(dir)) instanceof Cheese) return this.getLocation().getAdjacentLocation(dir);
            dir += 90;
        }
        return null;
    }

    private ArrayList<Location> getLocs() {
        ArrayList<Location> list = new ArrayList<>();
        int dir = 0;
        for (int i = 0; i < 4; i++) {
            if (this.getGrid().isValid(this.getLocation().getAdjacentLocation(dir)) && this.getGrid().get(this.getLocation().getAdjacentLocation(dir)) == null) list.add(this.getLocation().getAdjacentLocation(dir));
            dir += 90;
        }
        return list;
    }

    private Location findBreadcrumb() {
        ArrayList<Location> list = this.getGrid().getOccupiedAdjacentLocations(this.getLocation());
        for (int i = 0; i < list.size(); i++) {
            if (this.getGrid().get(list.get(i)) instanceof Breadcrumb) {
                return list.get(i);
            }
        }
        return null;
    }
}