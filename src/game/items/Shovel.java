package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Capabilities;

public class Shovel extends Item {
    public Shovel() {
        super("Shovel", 'S',true);
        this.addCapability(Capabilities.SHOVELABLE);
    }
}
