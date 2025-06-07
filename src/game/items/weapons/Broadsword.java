package game.items.weapons;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Affectionable;
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
 * Class representing a Broadsword WeaponItem. This will be a Buyable Item as well.
 * @author Serena Zhou
 */
public class Broadsword extends WeaponItem implements Buyable, Affectionable {

    /**
     * ArrayList of Broadsword's purchase effects
     */
    private List<PurchaseEffect> effects = new ArrayList<>();

    /**
     * Constructor
     *
     * @param cost of Broadsword
     */
    public Broadsword(int cost){
        super("Broadsword", 'b', 30, "slashes", 50, cost);
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

    /**
     * Method for executing what happens after the actor has purchased
     * @param actor who is purchasing a Buyable
     * @param map in which purchase is taking place
     * @return boolean whether the transaction was successful or not
     */
    @Override
    public boolean purchase(Actor actor, GameMap map) {
        affectFaction(actor);
        if (actor.getBalance() < cost) {
            return false;
        }
        actor.deductBalance(cost);
        actor.addItemToInventory(this);

        for (PurchaseEffect effect: this.getAllEffects()) {
            effect.applyEffect(actor, map);
        }
        return true;
    }

    @Override
    public void affectFaction(Actor actor) {
        Faction faction = FactionStandingManager.allFactions.get(Capabilities.MERCHANT);
        if (faction.getStanding() > 5) {
            faction.factionEffect(this);
        }
    }

    /**
     * Getter for how much the weapon costs
     * @return int the cost of the weapon
     */
    @Override
    public int getCost() {
        Faction faction = FactionStandingManager.allFactions.get(Capabilities.MERCHANT);
        if(faction.getStanding()>=5) {
            int oldCost = this.cost;
            this.modifyCost(2);
            int newCost = this.cost;
            this.cost = oldCost;
            return newCost;
        }
        else{
            return this.cost;
        }
    }
}
