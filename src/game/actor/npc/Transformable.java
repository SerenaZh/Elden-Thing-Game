package game.actor.npc;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface inherited by classes that can
 * transform into other creatures
 * @author Serena Zhou
 */
public interface Transformable {
    /**
     * Transform and returns the actor that's being transformed
     * @param map
     * @return the actor that the current Transformable transforms into
     */
    public Actor transform(GameMap map);
}
