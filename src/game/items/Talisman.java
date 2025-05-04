package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Capabilities;

/**
 * A class representing a Talisman that an actor can pick up and drop
 * @author Adrian Kristanto
 * modified by Serena Zhou
 */
public class Talisman extends Item {
    /**
     * Constructor of the Talisman
     */
    public Talisman() {
        super("Talisman", 'o', true);
        addCapability(Capabilities.CURABLE);
    }
}
