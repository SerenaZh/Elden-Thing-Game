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

public class DragonslayerGreatsword extends WeaponItem implements Buyable {
    private int cost;
    private List<PurchaseEffect> effects = new ArrayList<>();

    public DragonslayerGreatsword(int cost){
        super("Dragonslayer Greatsword", 'D', 70, "strikes", 75);
        this.addCapability(Capabilities.BUYABLE);
        this.cost = cost;
    }

    public List<PurchaseEffect> getAllEffects() {
        return Collections.unmodifiableList(effects);
    }

    public void addEffect(PurchaseEffect effect) {
        effects.add(effect);
    }

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
