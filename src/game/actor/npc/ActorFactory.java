package game.actor.npc;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * ActorFactory are implemented by Actors that can create more of themselves
 * @authors Serena Zhou & Aryan M
 */
public interface ActorFactory {
    /**
     * Creates a new instance of an Actor
     * @return a new Actor
     */
    public Actor createNewInstance();
}
