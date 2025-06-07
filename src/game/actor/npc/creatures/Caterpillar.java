package game.actor.npc.creatures;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.npc.ActorFactory;
import game.actor.npc.NonPlayableActor;
import game.actor.npc.Transformable;
import game.behaviours.ConsumeBehaviour;

/**
 * A cute little caterpillar that is hungry
 * wandering the world
 *
 * @author Serena Zhou
 */
public class Caterpillar extends NonPlayableActor implements Transformable {
    /**
     * What the Caterpillar will transform into
     */
    private Actor transformed;

    /**
     * Magic number for consume priority
     */
    private static final int consumeRank = 1;

    /**
     * Constructor
     */
    public Caterpillar(Actor transformed) {
        super("Catepillar", '8', 25);
        this.transformed = transformed;
        this.behaviours.put(consumeRank, new ConsumeBehaviour(this));
    }

    /**
     * Transforms the actor to a butterfly
     * @param map
     * @return
     */
    @Override
    public Actor transform(GameMap map) {
        Location location = map.locationOf(this);
        map.removeActor(this);
        location.addActor(transformed);
        return transformed;
    }
}
