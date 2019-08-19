package cs2.gridworld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

public class Runner {
    public static void main(String[] args) {
        Grid<Actor> gr = new BoundedGrid<Actor>(20, 20);
        ActorWorld world = new ActorWorld(gr);
        world.add(new MyBug());
        world.show();
    }
}
