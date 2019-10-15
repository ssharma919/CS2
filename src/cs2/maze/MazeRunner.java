package cs2.maze;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

public class MazeRunner {
    public static void main(String[] args) {
        Maze maze = new Maze(20,20);
        ActorWorld world = maze.printWorld(new Bug(),new Bug());
        world.show();
    }

}
