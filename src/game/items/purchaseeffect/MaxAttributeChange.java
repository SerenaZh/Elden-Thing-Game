package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;

public class MaxAttributeChange implements PurchaseEffect {
    int amount;
    BaseActorAttributes attribute;
    ActorAttributeOperations operation;

    public MaxAttributeChange(int amount, BaseActorAttributes attribute, ActorAttributeOperations operation) {
        this.amount = amount;
        this.attribute = attribute;
        this.operation = operation;
    }

    @Override
    public void applyEffect(Actor actor) {
        actor.modifyAttributeMaximum(attribute, operation, amount);
    }
}
