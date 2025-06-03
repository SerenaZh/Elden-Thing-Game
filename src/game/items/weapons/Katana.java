package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.BuyAction;
import game.actor.Ability;
import game.factions.Faction;
import game.factions.FactionStandingManager;
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
     * ArrayList of Katana's purchase effects
     */
    private List<PurchaseEffect> effects = new ArrayList<>();

    /**
     * Constructor
     *
     * @param cost of Katana
     */
    public Katana(int cost){
        super("Katana", 'j', 50, "slices", 60, cost);
        this.addCapability(Capabilities.BUYABLE);
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
        int oldCost = cost;
        enforceFactionEffect();
        if (actor.getBalance() < cost) {
            this.cost = oldCost;
            return false;
        }
        actor.deductBalance(cost);
        actor.addItemToInventory(this);
        actor.hurt(25);
        for (PurchaseEffect effect: this.getAllEffects()) {
            effect.applyEffect(actor, map);
        }
        this.cost = oldCost;
        return true;
    }

    @Override
    public void enforceFactionEffect() {
        Faction faction = FactionStandingManager.allFactions.get(Capabilities.MERCHANT);
        if(faction.getStanding()>=5){
            faction.factionEffect(this);
        }
    }

    /**
     * Getter for how much the weapon costs
     * @return int the cost of the weapon
     */
    @Override
    public int getCost() {
        int oldCost = this.cost;
        enforceFactionEffect();
        int newCost = this.cost;
        this.cost = oldCost;
        return newCost;
    }
}
