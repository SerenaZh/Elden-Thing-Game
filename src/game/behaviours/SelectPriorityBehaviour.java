package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;

/**
 * <h1>SelectPriorityBehaviour</h1>
 * A behaviour selection strategy that prioritizes behaviours based on their order in the map.
 * <p>
 * This class implements the standard behaviour selection mechanism where creatures evaluate
 * their behaviours in a predetermined priority order. The creature will attempt each behaviour
 * in sequence until it finds one that can be executed (returns a valid action), then performs
 * that action. If no behaviours are valid, the creature will do nothing for that turn.
 * </p>
 * <p>
 * This is the traditional behaviour selection method used in earlier assignments (A1 and A2)
 * and represents the methodical approach where creatures systematically check each behaviour
 * before deciding what to do.
 * </p>
 *
 * @author Khushi Rajpurohit
 */
public class SelectPriorityBehaviour implements SelectBehaviour {
    /**
     * Selects a behaviour to execute based on priority order.
     * Iterates through the behaviours map in order, checking each behaviour to see if it
     * can produce a valid action. Returns the action from the first valid behaviour found.
     *
     * @param behaviours a map of behaviours indexed by priority, where lower numbers indicate higher priority
     * @param actor the actor whose behaviour is being selected
     * @param map the current game map where the actor is located
     * @return the Action to be performed by the first valid behaviour, or null if no behaviours are valid
     */
    @Override
    public Action selectBehaviour(Map<Integer, Behaviour> behaviours, Actor actor, GameMap map) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(actor, map);
            if (action != null) {
                return action;
            }
        }
        return null;
    }
}
