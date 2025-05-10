package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actor.Ability;
import game.items.purchaseeffect.AttributeValueChange;
import game.items.purchaseeffect.MaxAttributeChange;
import game.items.purchaseeffect.SpawnActorChange;
import game.items.weapons.Broadsword;
import game.items.weapons.DragonslayerGreatsword;

public class MerchantKale extends NonPlayableActor {
    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
        this.addCapability(Ability.MERCHANT);
        setUpInventory();
    }

    private void setUpInventory() {
        Broadsword broadsword = new Broadsword(150);
        broadsword.addEffect(new MaxAttributeChange(30, BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE));

        DragonslayerGreatsword greatsword = new DragonslayerGreatsword(1700);
        greatsword.addEffect(new AttributeValueChange(20, BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE));

        this.addItemToInventory(broadsword);
        this.addItemToInventory(greatsword);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = super.allowableActions(otherActor, direction, map);
        for (Item item: getItemInventory()) {
            if (item.hasCapability(Capabilities.BUYABLE)) {
                actionList.add(item.allowableActions(this, map));
            }
        }
        return actionList;
    }
}
