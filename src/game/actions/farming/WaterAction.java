package game.actions.farming;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ground.plants.Thirsty;

/**
 * Able to water plants that are thirsty
 * Only takes in Thirsty plants
 *
 * @author Serena Zhou
 */
public class WaterAction extends Action {
    /**
     * The thirsty plant to be watered
     */
    private Thirsty thirstyPlant;

    /**
     * Constructor
     * @param thirstyPlant
     */
    public WaterAction(Thirsty thirstyPlant) {
        this.thirstyPlant = thirstyPlant;
    }

    /**
     * Executes the watering action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to be displayed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        thirstyPlant.water();
        actor.addBalance(100);
        return actor.toString() + " has watered the " + thirstyPlant.toString();
    }

    /**
     * Menu description when the player can execute the action
     * @param actor The actor performing the action.
     * @return The menu description String
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " waters " + thirstyPlant.toString();
    }
}
