package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.PlantAction;
import game.ground.Plant;

/**
 * Seed Item that can be carried by the Player
 * it can be dropped then planted onto the ground
 * @author Serena Zhou
 */
public class Seed extends Item {
    /**
     * The plant the seed grows into
     */
    private Plant plant;

    /**
     * Constructor of the Seed
     * @param plant that it will grow into
     */
    public Seed(Plant plant) {
        super(plant.toString() + " seed", '*', true);
        this.plant = plant;
    }

    /**
     * Gets the list of allowable actions that can be performed on the seed
     * @param location the location of the ground on which the item lies
     * @return A list of actions that can be performed
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = new ActionList();
        if (location.getGround().hasCapability(Capabilities.PLANTABLE)) {
            actions.add(new PlantAction(this, plant));
        }

        return actions;
    }
}
