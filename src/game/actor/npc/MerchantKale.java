package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actor.Ability;
import game.items.purchaseeffect.MaxAttributeChange;
import game.items.purchaseeffect.SpawnActorChange;
import game.items.weapons.Broadsword;

public class MerchantKale extends NonPlayableActor {
    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
        Broadsword broadsword = new Broadsword(150);
        broadsword.addEffect(new MaxAttributeChange(15, BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE));
        broadsword.addEffect(new SpawnActorChange(new OmenSheep()));
        this.addItemToInventory(broadsword);
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
