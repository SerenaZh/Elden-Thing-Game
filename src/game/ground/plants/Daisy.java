package game.ground.plants;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ground.Plant;
import game.ground.Soil;

public class Daisy extends Ground implements Plant, Thirsty {
    private int waterLevel = 10;

    public Daisy() {super('d', "Daisy");}

    @Override
    public boolean applyPlant(Actor actor, GameMap map) {
        return false;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        this.decreaseCounter();
        if (this.waterLevel <= 0) {
            location.setGround(new Soil());
        }
    }

    @Override
    public void water() {

    }

    @Override
    public void decreaseCounter() {
        this.waterLevel -= 1;
    }
}
