package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface to describe things that can be cured of
 * something
 *
 * @author Serena Zhou
 */
public interface Curable {
    /**
     * Cures the thing of rotting
     * @param actor that is curing
     * @param map of the Game
     * @return boolean if it has been cured or not
     */
    boolean cure(Actor actor, GameMap map);
}
