package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.List;

/**
 * Interface for NPCs that can speak monologues when interacted with.
 *
 * @author Mohammed A
 */
public interface MonologueCapable {
    /**
     * Returns a list of valid monologue lines based on current world state.
     *
     * @param listener The actor that is listening (typically the player).
     * @param map The current game map.
     * @return A list of possible monologue lines.
     */
    List<String> generateMonologuePool(Actor listener, GameMap map);
}
