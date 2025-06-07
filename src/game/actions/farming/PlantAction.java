package game.actions.farming;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ground.plants.Plant;

/**
 * Class representing the action to plant seeds
 * Class will only plant classes implementing Planting
 * otherwise it will throw an error
 * @author Serena Zhou
 */
public class PlantAction extends Action {
    /**
     * The plant to be planted
     */
    private Plant plant;
    /**
     * The seed Item that has dropped on the ground
     * to be planted
     */
    private Item seed;

    /**
     * Constructor
     * @param seed to be planted
     * @param plant the plant to be grown into
     */
    public PlantAction(Item seed, Plant plant) {
        this.plant = plant;
        this.seed = seed;
    }

    /**
     * Executes the planting action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to be printed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(seed);
        if (plant.applyPlant(actor, map)) {
            return actor.toString() + " has planted the " + seed.toString();
        } else {
            return actor.toString() + " has ran out of stamina to plant " + seed.toString();
        }
    }

    /**
     * Shows the text option to be displayed on the terminal
     * @param actor The actor performing the action.
     * @return String to be printed
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " plants the " + seed.toString();
    }

}
