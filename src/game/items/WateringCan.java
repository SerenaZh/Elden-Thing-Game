package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.WaterAction;

public class WateringCan extends Item {
    public WateringCan() {
        super("Watering Can", 'C', true);
        this.addCapability(Capabilities.WATERABLE);
    }
}
