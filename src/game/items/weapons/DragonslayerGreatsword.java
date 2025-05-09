package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.BuyAction;
import game.actor.Ability;
import game.items.Buyable;

public class DragonslayerGreatsword extends WeaponItem implements Buyable {
    private int cost;

    public DragonslayerGreatsword(){
        super("Dragonslayer Greatsword", 'D', 70, "strikes", 75);
        this.addCapability(Capabilities.BUYABLE);
        this.cost = cost;
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
