package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actor.npc.GoldenBeetle;

/**
 * An action that allows an actor (e.g., the player) to consume another actor (such as the Golden Beetle).
 * Consuming the target grants specific benefits, such as health and runes, and removes the target from the map.
 *
 * @author Khushi R
 */
public class ConsumeAction extends Action {

    /**
     * The target actor to be consumed.
     */
    private final Actor target;
    /**
     * A short description of the effect that consuming the target provides.
     */
    private final String effectDescription;

    /**
     * Constructs a new ConsumeAction.
     *
     * @param target             the actor to be consumed
     * @param effectDescription  a description of the benefits of consumption
     */
    public ConsumeAction(Actor target, String effectDescription) {
        this.target = target;
        this.effectDescription = effectDescription;
    }

    /**
     * Executes the consume action. If the target is a Golden Beetle, the actor gains health and runes,
     * and the beetle is removed from the map.
     *
     * @param actor the actor performing the action
     * @param map   the game map
     * @return a string describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (target instanceof GoldenBeetle) {
            actor.heal(15);
            actor.addBalance(1000);
            map.removeActor(target);
            return actor + " consumed the Golden Beetle. Healed 15 HP and gained 1000 runes.";
        }
        return actor + " tried to consume " + target + ", but nothing happened.";
    }

    /**
     * Returns a description of the action for display in the menu.
     *
     * @param actor the actor performing the action
     * @return a string description of the menu option
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + target + " (" + effectDescription + ")";
    }
}
