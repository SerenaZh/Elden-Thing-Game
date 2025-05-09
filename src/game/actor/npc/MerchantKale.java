package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actor.Ability;
import game.items.weapons.Broadsword;

public class MerchantKale extends NonPlayableActor {
    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
        this.addItemToInventory(new Broadsword(150));
        this.addCapability(Ability.MERCHANT);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = super.allowableActions(otherActor, direction, map);
        for (Item item: this.getItemInventory()) {
            if (item.hasCapability(Capabilities.BUYABLE)) {
                actionList.add(item.allowableActions(this, map));
            }
        }
        return actionList;
    }
}
