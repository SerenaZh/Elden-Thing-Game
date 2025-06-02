package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Capabilities;

public class WateringCan extends Item {
    public WateringCan() {
        super("Watering Can", 'C', true);
        this.addCapability(Capabilities.WATERABLE);
    }
}
