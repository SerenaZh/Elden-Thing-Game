package game.items.purchaseeffect;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class representing a PurchaseEffect which changes the maximum value of an actor's attributes(s)
 * @author Serena Zhou and Aryan M
 */
public class MaxAttributeChange implements PurchaseEffect {
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
     * Constructor
     */
    public MaxAttributeChange(int amount, BaseActorAttributes attribute, ActorAttributeOperations operation) {
        this.amount = amount;
        this.attribute = attribute;
        this.operation = operation;
    }

    @Override
    public void applyEffect(Actor actor, GameMap map) {
        actor.modifyAttributeMaximum(attribute, operation, amount);
    }
}
