package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.Capabilities;

/**
 * A class representing the soil in the valley
 * @author Adrian Kristanto
 * modified by Serena Zhou
 */
public class Soil extends Ground {
    /**
     * Constructor for Soil
     */
    public Soil() {
        super('.', "Soil");
        this.addCapability(Capabilities.PLANTABLE);
    }
}
