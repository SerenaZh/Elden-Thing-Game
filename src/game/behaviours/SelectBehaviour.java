package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;

/**
 * Interface for selecting a behaviour to execute from a set of available behaviours.
 * Implementing classes define different strategies for selecting which behaviour to act on.
 */
public interface SelectBehaviour {
    /**
     * Selects and returns an action based on the available behaviours for an actor.
     * The specific selection strategy depends on the implementing class.
     *
     * @param behaviours a map of available behaviours indexed by priority
     * @param actor the actor for whom a behaviour is being selected
     * @param map the current game map where the actor is located
     * @return the Action to be performed, or null if no valid behaviour can be executed
     */
    Action selectBehaviour(Map<Integer, Behaviour> behaviours, Actor actor, GameMap map);
}
