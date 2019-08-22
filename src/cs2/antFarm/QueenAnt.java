package cs2.antFarm;


import java.awt.*;

public class QueenAnt extends Ant {

    public QueenAnt() {
        this.setColor(Color.MAGENTA);
    }

    public void process(WorkerAnt ant) {
        int food = ant.getFood();
        this.setFood(this.getFood() + food);
        ant.setFood(0);
        ant.setQueenLoc(this.getLocation());
        ant.setColor(Color.BLACK);
    }
}
