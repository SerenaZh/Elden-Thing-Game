package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Buyable;

public class BuyAction extends Action {
    private Buyable buyable;

    @Override
    public String execute(Actor actor, GameMap map) {
        return "";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "";
    }
}
