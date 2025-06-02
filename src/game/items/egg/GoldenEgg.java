package game.items.egg;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;
import game.actor.npc.ActorFactory;

/**
 * A special type of Egg that hatches into a Golden Beetle when placed near cursed ground,
 * or can be consumed by the player to restore stamina.
 *
 * @author Khushi R
 */
public class GoldenEgg extends Egg {

    /**
     * Constructs a GoldenEgg with the specified actor factory.
     *
     * @param actorFactory the factory used to create a Golden Beetle when the egg hatches
     */
    public GoldenEgg(ActorFactory actorFactory) {
        super("Golden Egg", '0', actorFactory);
    }

    /**
     * Determines if the egg should hatch based on its surroundings.
     * The Golden Egg hatches if it is adjacent to any cursed ground (e.g., Blight).
     *
     * @param location the current location of the egg
     * @return true if the egg is near cursed ground, false otherwise
     */
    @Override
    public boolean hatchConditionMet(Location location) {
        return location.getExits().stream()
                .map(exit -> exit.getDestination().getGround())
                .anyMatch(ground -> ground.hasCapability(Capabilities.CURSED));
    }

    /**
     * When consumed by an actor, restores 20 stamina points.
     *
     * @param actor the actor consuming the egg
     */
    @Override
    public void consume(Actor actor) {
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, 20);
    }
}
