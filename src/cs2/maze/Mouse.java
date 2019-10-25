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
    private int startTrack;

    public Mouse () {
        stack = new Stack<>();
        stackTrack = new Stack<>();
        nextLoc = null;
        oldLoc = null;
        startTrack = 0;
    }

    public void act() {
        if (findCheese() != null) {
            return;
        }
        ArrayList<Location> list = this.getLocs();
        if (list.size() > 1 && startTrack != 2) {
            startTrack = 1;
//            stackTrack.push(this.getLocation());
        }
        if (startTrack != 2) {
            for (int i = 0; i < list.size(); i++) {
                stack.push(list.get(i));
            }
            if (startTrack == 1 && list.size() != 0) stackTrack.push(stack.peek());
        }
//        if (startTrack != 0) System.out.println(stackTrack.peek() + " " + list.size());
        if (list.size() == 0) {
            startTrack = 2;
            nextLoc = stackTrack.pop();
        }


        if (startTrack == 2) {

            nextLoc = stackTrack.pop();
            if (stackTrack.empty()) {
                startTrack = 0;
                return;
            }
            System.out.println(nextLoc + " " + stackTrack.empty() + " " + startTrack);
            System.out.println();
            this.setDirection(this.getLocation().getDirectionToward(nextLoc));
            this.getGrid().remove(nextLoc);
            moveTo(nextLoc);

        }
        else {
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

//    private Location findBreadcrumb() {
//        ArrayList<Location> list = this.getGrid().getOccupiedAdjacentLocations(this.getLocation());
//        for (int i = 0; i < list.size(); i++) {
//            if (this.getGrid().get(list.get(i)) instanceof Breadcrumb) {
//                return list.get(i);
//            }
//        }
//        return null;
//    }
}