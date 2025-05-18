package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Buyable;

/**
 * Class representing an action to buy
 * Player will only be able to Buy Items which implement
 * Buyable; things that can be bought.
 * @authors Serena Zhou and Aryan M
 */

public class BuyAction extends Action {
    /**
     * Item that can be bought
     */
    private Buyable buyable;

    /**
     * Constructor
     * @param buyable Item which can be bought
     */
    public BuyAction(Buyable buyable){
        this.buyable = buyable;
    }

    /**
     * Constructor
     * @param actor that is buying the buyable
     * @param map map player is.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (buyable.purchase(actor, map)) {
            return actor.toString() + " has bought " + buyable.toString();
        }
        return actor.toString() + " has insufficient runes " + buyable.toString();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " buys " + buyable.toString() + " with " + buyable.getCost() + " runes";
    }
}
