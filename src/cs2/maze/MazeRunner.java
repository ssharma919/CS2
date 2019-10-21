package cs2.maze;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;

public class MazeRunner {
    public static void main(String[] args) {
        Maze maze = new Maze(10,10);
        ActorWorld world = maze.printWorld(new Mouse(),new Cheese());
//        maze.printWorld(new Mouse(), new Cheese()).show();
        world.show();
    }

}
