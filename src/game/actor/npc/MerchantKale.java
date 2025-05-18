package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.BuyAction;
import game.actor.Ability;
import game.items.Buyable;
import game.items.purchaseeffect.AttributeValueChange;
import game.items.purchaseeffect.MaxAttributeChange;
import game.items.purchaseeffect.SpawnActorChange;
import game.items.weapons.Broadsword;
import game.items.weapons.DragonslayerGreatsword;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the merchant Kale NPC
 * @authors Serena Zhou and Aryan M
 */
public class MerchantKale extends NonPlayableActor {
    /**
     * Constructor for Merchant Kale
     */
    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
        this.addCapability(Ability.MERCHANT);
        getBuyables();
    }

    /**
     * Method to create merchant specific items and return a list of these buyables
     *
     * @return List of all buyables carries by merchant
     */
    private  List<Buyable> getBuyables() {
        List<Buyable> buyableList = new ArrayList<>();
        Broadsword broadsword = new Broadsword(150);
        broadsword.addEffect(new MaxAttributeChange(30, BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE));

        DragonslayerGreatsword greatsword = new DragonslayerGreatsword(1700);
        greatsword.addEffect(new AttributeValueChange(20, BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE));

        buyableList.add(broadsword);
        buyableList.add(greatsword);
        return buyableList;
    }

    /**
     * Allowable actions that another Actor can do to this Actor
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList a list of actions that can be done
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = super.allowableActions(otherActor, direction, map);
        for (Buyable buyable: getBuyables()) {
            actionList.add(new BuyAction(buyable));
        }
        return actionList;
    }
}
