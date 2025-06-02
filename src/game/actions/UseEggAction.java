package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.egg.Egg;

/**
 * An action that allows an actor to consume an {@link Egg} from their inventory.
 * <p>
 * When executed, it applies the egg's effect to the actor and removes the egg from the actor's inventory.
 * This action is applicable to any item that extends the {@code Egg} class, such as {@code GoldenEgg} or {@code OmenEgg}.
 *
 * @author Sandeesa R
 */
public class UseEggAction extends Action {

    /**
     * The {@link Egg} item to be consumed.
     */
    private final Egg egg;

    /**
     * Constructs a new {@code UseEggAction} for the specified egg.
     *
     * @param egg the {@link Egg} to be consumed
     */
    public UseEggAction(Egg egg) {
        this.egg = egg;
    }

    /**
     * Executes the action: the actor consumes the egg, triggering its effects,
     * and the egg is removed from the actor's inventory.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A string describing the result of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        egg.consume(actor);
        actor.removeItemFromInventory(egg);
        return actor + " consumed the " + egg;
    }

    /**
     * Returns a string describing this action for display in the game menu.
     *
     * @param actor The actor performing the action.
     * @return A string description of the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " eats " + egg;
    }
}