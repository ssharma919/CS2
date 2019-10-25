package cs2.maze;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Stack;

public class Mouse extends Actor {

    private Stack<Location> stack;
    private Stack<Location> stackTrack;
    private Location nextLoc;
    private Location oldLoc;
    private boolean startTrack;

    public Mouse () {
        stack = new Stack<>();
        stackTrack = new Stack<>();
        nextLoc = null;
        oldLoc = null;
        startTrack = false;
    }

    public void act() {
        if (findCheese() != null) {
            return;
        }
        else {
            ArrayList<Location> list = this.getLocs();
            if (list.size() == 0) startTrack = true;
            if (!startTrack) {
                stackTrack.push(this.getLocation());
                for (int i = 0; i < list.size(); i++) {
                    stack.push(list.get(i));
                }
            }
            if (startTrack) {
                if (list.contains(stack.peek())) {
                    startTrack = false;
                    return;
                }
                nextLoc = stackTrack.pop();
                System.out.println(nextLoc + " " + this.getLocation());
                this.setDirection(this.getLocation().getDirectionToward(nextLoc));
                this.getGrid().get(nextLoc).removeSelfFromGrid();
                moveTo(nextLoc);
            }
            else {
                nextLoc = stack.pop();
                oldLoc = this.getLocation();
                this.setDirection(this.getLocation().getDirectionToward(nextLoc));
                moveTo(nextLoc);
                (new Breadcrumb()).putSelfInGrid(this.getGrid(), oldLoc);
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
}