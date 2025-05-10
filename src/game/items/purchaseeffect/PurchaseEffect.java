package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface PurchaseEffect {
    void applyEffect(Actor actor, GameMap map);
}
