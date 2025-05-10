package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.BuyAction;
import game.actor.Ability;
import game.items.Buyable;

public class Broadsword extends WeaponItem implements Buyable {
    private int cost;
    public Broadsword(int cost){
        super("Broadsword", 'b', 30, "slashes", 50);
        this.addCapability(Capabilities.BUYABLE);
        this.cost = cost;
    }

    public void test() {

    }

    @Override
    public boolean purchase(Actor actor, GameMap map) {
        if (actor.getBalance() < cost) {
            return false;
        }
        actor.deductBalance(cost);
        actor.addItemToInventory(this);
        return true;
    }

    @Override
    public ActionList allowableActions(Actor owner, GameMap map) {
        ActionList actionList = super.allowableActions(owner, map);
        if (owner.hasCapability(Ability.MERCHANT)) {
            actionList.add(new BuyAction(this));
        }
        return actionList;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
