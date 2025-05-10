package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;

public class AttributeValueChange implements PurchaseEffect {
    int amount;
    BaseActorAttributes attribute;
    ActorAttributeOperations operation;

    public AttributeValueChange(int amount, BaseActorAttributes attribute, ActorAttributeOperations operation) {
        this.amount = amount;
        this.attribute = attribute;
        this.operation = operation;
    }

    @Override
    public void applyEffect(Actor actor, GameMap map) {
        actor.modifyAttribute(attribute, operation, amount);
    }
}
