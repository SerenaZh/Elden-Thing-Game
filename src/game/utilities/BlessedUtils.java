package game.utilities;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;

/**
 * Utility class for checking blessed entities or grounds in the surroundings.
 *
 * @author Sandeesa R
 */
public class BlessedUtils {
    //Checks if a location is surrounded by blessed entities or grounds.
    public static boolean isSurroundedByBlessed(Location location) {
        for (Exit exit : location.getExits()) {
            Location destination = exit.getDestination();
            if (destination.getGround().hasCapability(Capabilities.BLESSED_BY_GRACE)) {
                return true;
            }
        }
        return false;
    }
}