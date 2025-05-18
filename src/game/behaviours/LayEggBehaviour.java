package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A behavior that causes an actor to lay an egg every 5 turns.
 * The egg is removed from the actor's inventory and added to the current location on the map.
 *
 * @author Khushi R
 */
public class LayEggBehaviour implements Behaviour {

    /**
     * The egg item that will be laid.
     */
    private final Item egg;
    /**
     * Internal counter to track turns.
     */
    private int counter = 0;

    /**
     * Constructs a LayEggBehaviour that lays the specified egg.
     *
     * @param egg the egg item to be laid
     */
    public LayEggBehaviour(Item egg) {
        this.egg = egg;
    }

    /**
     * Returns an action to lay an egg every 5 turns.
     * The egg is dropped from the inventory and placed on the map at the actor's current location.
     *
     * @param actor the actor performing the behaviour
     * @param map   the game map
     * @return an Action to lay the egg every 5 turns, or null otherwise
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        counter++;

        if (counter % 5 == 0) {
            return new Action() {
                @Override
                public String execute(Actor actor, GameMap map) {
                    Location here = map.locationOf(actor);
                    actor.removeItemFromInventory(egg);
                    here.addItem(egg);
                    return actor + " laid an egg.";
                }

                @Override
                public String menuDescription(Actor actor) {
                    return actor + " lays an egg";
                }
            };
        }

        return null;
    }
}
