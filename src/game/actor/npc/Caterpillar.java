package game.actor.npc;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.ConsumeBehaviour;

public class Caterpillar extends NonPlayableActor implements Transformable {
    public static final int consumeRank = 1;

    public Caterpillar() {
        super("Catepillar", '8', 25);
        this.behaviours.put(consumeRank, new ConsumeBehaviour(this));
    }

    @Override
    public Actor transform(GameMap map) {
        Location location = map.locationOf(this);
        map.removeActor(this);
        Actor butterfly = new AeonianButterfly();
        location.addActor(butterfly);
        return butterfly;
    }
}
