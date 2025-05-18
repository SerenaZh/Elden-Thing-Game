package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
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
 * Class representing a Katana WeaponItem. This will be a Buyable Item as well.
 * @author Serena Zhou
 */
public class Katana extends WeaponItem implements Buyable {
    /**
     * cost of Katana
     */
    private int cost;
    /**
     * ArrayList of Katana's purchase effects
     */
    private List<PurchaseEffect> effects = new ArrayList<>();

    /**
     * Constructor
     *
     * @param cost of Katana
     */
    public Katana(int cost){
        super("Katana", 'j', 50, "slices", 60);
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
     * Method for retrieving all purchase effects of Item
     *
     * @return List<PurchaseEffect> list of Purchase Effects for Item
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

    /**
     * Method for executing what happens after the actor has purchased
     * @param actor who is purchasing a Buyable
     * @param map in which purchase is taking place
     * @return boolean whether the transaction was successful or not
     */
    @Override
    public boolean purchase(Actor actor, GameMap map) {
        if (actor.getBalance() < cost) {
            return false;
        }
        actor.deductBalance(cost);
        actor.addItemToInventory(this);
        actor.hurt(25);
        for (PurchaseEffect effect: this.getAllEffects()) {
            effect.applyEffect(actor, map);
        }
        return true;
    }

    /**
     * Getter for how much the weapon costs
     * @return int the cost of the weapon
     */
    @Override
    public int getCost() {
        return cost;
    }
}
