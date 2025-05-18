package game.actor.npc;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Class representing the Golden Beetle NPC
 * @author Serena Zhou
 */
public class GoldenBeetle extends NonPlayableActor implements ActorFactory {
    /**
     * Constructor for GoldenBeetle
     */
    public GoldenBeetle() {
        super("Golden Beetle", 'b', 25);
    }

    /**
     * Creates a new instance of this class
     * @return Actor a new instance
     */
    @Override
    public Actor createNewInstance() {
        return new GoldenBeetle();
    }
}
