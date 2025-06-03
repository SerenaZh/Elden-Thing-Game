package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing an Item which can be bought
 * @authors Serena Zhou and Aryan M
 */
public interface Buyable {
    /**
     *
     * Method for completing purchase logic including updating inventories and player balance.
     * @param actor who is purchasing a Buyable
     * @param gameMap in which purchase is taking place
     * @return boolean confirming if purchase was successful
     */
    boolean purchase(Actor actor, GameMap gameMap);

    /**
     *
     * Method for getting the cost of a Buyable
     * @return int reflecting the cost of the Buyable
     */
    int getCost();

    void enforceFactionEffect();
}
