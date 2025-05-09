package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Buyable;

public class BuyAction extends Action {
    private Buyable buyable;

    public BuyAction(Buyable buyable){
        this.buyable = buyable;
    }
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
