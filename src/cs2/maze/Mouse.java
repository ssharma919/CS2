package cs2.maze;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Stack;

public class Mouse extends Actor {

    private Stack<Location> stack;
    private Location nextLoc;
    private Location oldLoc;
    private Location cheeseLoc;

    public Mouse () {
        stack = new Stack<>();
        nextLoc = null;
        oldLoc = null;
        cheeseLoc = null;
    }

    public void act() {
        if (findCheese() != null) {
            if (cheeseLoc != this.getLocation()) {
                System.out.println("test");
                cheeseLoc = this.findCheese();
                this.getGrid().remove(cheeseLoc);
                moveTo(cheeseLoc);
            }
        }
        else {
            ArrayList<Location> list = this.getLocs();
            for (int i = 0; i < list.size(); i++) {
                stack.push(list.get(i));
            }
            nextLoc = stack.pop();
            oldLoc = this.getLocation();
            this.setDirection(this.getLocation().getDirectionToward(nextLoc));
            moveTo(nextLoc);
            this.getGrid().put(oldLoc, new Breadcrumb());
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
}

