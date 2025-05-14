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
    private int amount;
    /**
     * The attribute which is being altered
     */
    private BaseActorAttributes attribute;
    /**
     * The operation used to alter attribute (INCREASE, DECREASE, or UPDATE )
     */
    private ActorAttributeOperations operation;

    /**
     * Constructor
     *
     * @param amount by which a given attribute is being altered.
     * @param attribute which is being altered
     * @param operation used to alter attribute (INCREASE, DECREASE, or UPDATE )
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
