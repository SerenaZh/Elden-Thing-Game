package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.Capabilities;

/**
 * A hole
 *
 * @author Serena Zhou
 */
public class Hole extends Ground {
    /**
     * Constructor
     */
    public Hole() {
        super('O', "Hole");
        this.addCapability(Capabilities.TILLED);
    }
}
