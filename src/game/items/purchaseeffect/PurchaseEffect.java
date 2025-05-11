package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing the effect of a purchase on an actor
 * @author Serena Zhou and Aryan M
 */
public interface PurchaseEffect {
    /**
     * Method to apply the effects to an actor
     * @param actor affected
     * @param map in which effect takes place
     */
    void applyEffect(Actor actor, GameMap map);
}
