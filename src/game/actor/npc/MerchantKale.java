package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actions.BuyAction;
import game.actions.ListenAction;
import game.behaviours.MonologueCapable;
import game.behaviours.SelectPriorityBehaviour;
import game.items.Buyable;
import game.items.purchaseeffect.AttributeValueChange;
import game.items.purchaseeffect.MaxAttributeChange;
import game.items.weapons.Broadsword;
import game.items.weapons.DragonslayerGreatsword;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the merchant Kale NPC
 * @authors Serena Zhou and Aryan M and Mohammed A
 */
public class MerchantKale extends NonPlayableActor implements MonologueCapable {
    /**
     * Constructor for Merchant Kale
     */
    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
        getBuyables();
        this.addCapability(Capabilities.MERCHANT);
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
     * Generates the monologue for this actor
     * @param listener The actor that is listening (typically the player).
     * @param map The current game map.
     * @return List of Strings of monologue options
     */
    @Override
    public List<String> generateMonologuePool(Actor listener, GameMap map) {
        List<String> pool = new ArrayList<>();

        boolean hasLowRunes = listener.getBalance() < 500;
        boolean hasEmptyInventory = listener.getItemInventory().isEmpty();
        boolean nearCursed = isNearCapability(map.locationOf(this), Capabilities.CURSED);

        if (hasLowRunes) {
            pool.add("Ah, hard times, I see. Keep your head low and your blade sharp.");
        }

        if (hasEmptyInventory) {
            pool.add("Not a scrap to your name? Even a farmer should carry a trinket or two.");
        }

        if (nearCursed) {
            pool.add("Rest by the flame when you can, friend. These lands will wear you thin.");
        }

        if (pool.isEmpty()) {
            pool.add("A merchant’s life is a lonely one. But the roads… they whisper secrets to those who listen.");
        }

        return pool;
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
        actionList.add(new ListenAction(this));
        return actionList;
    }

    /**
     * Checks if actor is near location that has a specific capability
     * @param location
     * @param capability
     * @return
     */
    private boolean isNearCapability(Location location, Capabilities capability) {
        for (Exit exit : location.getExits()) {
            if (exit.getDestination().getGround().hasCapability(capability)) {
                return true;
            }
        }
        return false;
    }
}
