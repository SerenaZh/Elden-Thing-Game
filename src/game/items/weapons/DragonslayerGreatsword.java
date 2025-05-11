package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.BuyAction;
import game.actor.Ability;
import game.items.Buyable;
import game.items.purchaseeffect.PurchaseEffect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a Dragonslayer Greatsword WeaponItem. This will be a Buyable Item as well.
 * @author Serena Zhou
 */
public class DragonslayerGreatsword extends WeaponItem implements Buyable {
    /**
     * cost of Broadsword
     */
    private int cost;
    /**
     * ArrayList of Dragonslayer Greatsword's purchase effects
     */
    private List<PurchaseEffect> effects = new ArrayList<>();

    /**
     * Constructor
     *
     * @param cost of Dragonslayer Greatsword
     */
    public DragonslayerGreatsword(int cost){
        super("Dragonslayer Greatsword", 'D', 70, "strikes", 75);
        this.addCapability(Capabilities.BUYABLE);
        this.cost = cost;
    }

    /**
     * Method for retrieving all purchase effects of Item
     *
     * @return List<PurchaseEffect> list of Purchase Effects for Item
     */
    public List<PurchaseEffect> getAllEffects() {
        return Collections.unmodifiableList(effects);
    }

    /**
     * Method for adding a purchase effect to item
     *
     * @param effect being added
     */
    public void addEffect(PurchaseEffect effect) {
        effects.add(effect);
    }

    /**
     * Method for removing a purchase effect to item
     *
     * @param effect being removed
     */
    public void removeEffect(PurchaseEffect effect) {
        effects.remove(effect);
    }

    @Override
    public boolean purchase(Actor actor, GameMap map) {
        if (actor.getBalance() < cost) {
            return false;
        }
        actor.deductBalance(cost);
        actor.addItemToInventory(this);

        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 15);

        for (PurchaseEffect effect: this.getAllEffects()) {
            effect.applyEffect(actor, map);
        }
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
