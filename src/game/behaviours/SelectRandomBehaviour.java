package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <h1>SelectRandomBehaviour</h1>
 * A behaviour selection strategy that randomly chooses one behaviour to attempt each turn.
 * <p>
 * This class implements an alternative behaviour selection mechanism introduced in REQ1 where
 * creatures select a single behaviour at random from their available options. Unlike the
 * priority-based approach, if the randomly chosen behaviour cannot be executed (returns null),
 * the creature will do nothing for that turn rather than trying alternative behaviours.
 * </p>
 * <p>
 * This creates more unpredictable and varied creature behavior, as creatures may attempt
 * different actions each turn based on chance rather than following a predetermined priority
 * order. For example, a Spirit Goat might choose to wander on one turn and attempt to
 * reproduce on another, regardless of which action is more "important".
 * </p>
 *
 * @author Khushi Rajpurohit
 */
public class SelectRandomBehaviour implements SelectBehaviour {
    /**
     * Random number generator used for behaviour selection
     */
    private final Random rand = new Random();

    /**
     * Randomly selects a behaviour to execute.
     * Converts the behaviours map to a list, randomly selects one behaviour from the available
     * options, and attempts to get an action from that behaviour. If the chosen behaviour
     * cannot produce a valid action, returns null (creature does nothing).
     *
     * @param behaviours a map of available behaviours for the actor
     * @param actor the actor whose behaviour is being selected
     * @param map the current game map where the actor is located
     * @return the Action from the randomly chosen behaviour, or null if the behaviour is invalid or no behaviours exist
     */
    @Override
    public Action selectBehaviour(Map<Integer, Behaviour> behaviours, Actor actor, GameMap map) {
        List<Behaviour> options = new ArrayList<>(behaviours.values());
        if (options.isEmpty()) return null;
        Behaviour chosen = options.get(rand.nextInt(options.size()));
        return chosen.getAction(actor, map);
    }
}
