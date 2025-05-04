package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface for things that can be planted
 * @author Serena Zhou
 */
public interface Planting {
    /**
     * Plants the plant into the ground
     * @param actor doing the planting
     * @param map of the Game
     * @return boolean if the plant has been planted or not
     */
    public boolean applyPlant(Actor actor, GameMap map);
}
