package game.ground.plants;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.ground.Plant;

public class Lilac extends Ground implements Plant {

    public Lilac() {super('l', "Lilac");}

    @Override
    public boolean applyPlant(Actor actor, GameMap map) {
        return false;
    }
}
