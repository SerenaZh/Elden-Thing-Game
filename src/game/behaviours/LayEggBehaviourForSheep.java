package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.items.egg.OmenEgg;

/**
 * A behaviour for the Omen Sheep that causes it to lay an {@link OmenEgg}every 7 turns.
 * The egg is removed from the sheep's inventory and placed on the ground at its current location.
 *
 * @author Khushi R
 */
public class LayEggBehaviourForSheep implements Behaviour {

    /**
     * The egg instance to be laid by the Omen Sheep.
     */
    private final OmenEgg egg = new OmenEgg();
    /**
     * Counter to track how many turns have passed.
     */
    private int counter = 0;

    /**
     * Returns an Action for laying an egg every 7 turns. If the turn count is divisible by 7,
     * returns an action that places the egg on the map.
     * Otherwise, returns null.
     *
     * @param actor the actor performing the behaviour
     * @param map   the game map the actor is on
     * @return an Action to lay the egg, or null if no action this turn
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        counter++;

        if (counter % 7 == 0) {
            return new Action() {
                @Override
                public String execute(Actor actor, GameMap map) {
                    Location location = map.locationOf(actor);
                    actor.removeItemFromInventory(egg);
                    location.addItem(egg);
                    return actor + " laid an omen egg.";
                }

                @Override
                public String menuDescription(Actor actor) {
                    return actor + " lays an omen egg";
                }
            };
        }

        return null;
    }
}

