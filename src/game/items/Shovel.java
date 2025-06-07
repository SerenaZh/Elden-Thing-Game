package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Capabilities;

/**
 * A trusty shovel for hole digging
 *
 * @author Serena Zhou
 */
public class Shovel extends Item {
    /**
     * Constructor
     */
    public Shovel() {
        super("Shovel", 'S',true);
        this.addCapability(Capabilities.SHOVELABLE);
    }
}
