// Extension: Added ZombieAnt that kills WorkerAnts if they hold food. Takes WorkerAnts food and stores it for itself

package cs2.antFarm;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

public class AntFarmRunner {
    public static void main(String[] args) {
        Grid<Actor> g = new BoundedGrid<Actor>(19, 19);
        ActorWorld world = new ActorWorld(g);

        world.add(new Cookie());
        world.add(new Cake());
        world.add(new QueenAnt());
        world.add(new ZombieAnt());
        for (int i = 0; i < 20; i++) {
            world.add(new WorkerAnt());
        }

        world.show();
    }
}
