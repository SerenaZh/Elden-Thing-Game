package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class representing a PurchaseEffect which changes the value of an actor's attributes(s)
 * @author Serena Zhou and Aryan M
 */
public class AttributeValueChange implements PurchaseEffect {
    /**
     * The amount by which a given attribute is being altered.
     */
    int amount;
    /**
     * The attribute which is being altered
     */
    BaseActorAttributes attribute;
    /**
     * The operation used to alter attribute (INCREASE, DECREASE, or UPDATE )
     */
    ActorAttributeOperations operation;

    /**
     * Constructor for class
     */
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
