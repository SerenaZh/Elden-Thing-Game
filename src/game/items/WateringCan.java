package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.Capabilities;

/**
 * So hey who is thirsty?
 * A watering can to water anything
 *
 * @author Serena Zhou
 */
public class WateringCan extends Item {
    /**
     * Constructor
     */
    public WateringCan() {
        super("Watering Can", 'C', true);
        this.addCapability(Capabilities.WATERABLE);
    }
}
