package game.items.egg;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.npc.creatures.OmenSheep;
import game.actor.npc.ActorFactory;

/**
 * Represents an egg laid by an Omen Sheep.
 * <p>
 * The egg hatches into a new {@link OmenSheep} after it has spent
 * 3 turns on the ground without being picked up.
 * If consumed from inventory, it increases the actor's maximum health by 10 points.
 *
 * @author Khushi R & Sandeesa R
 */
public class OmenEgg extends Egg {

    /**
     * Tracks the number of turns the egg has been on the ground.
     */
    private int groundCounter = 0;

    /**
     * Constructs a new OmenEgg with a factory that spawns an OmenSheep upon hatching.
     */
    public OmenEgg() {
        super("Omen Egg", '0', new ActorFactory() {
            @Override
            public Actor createNewInstance() {
                return new OmenSheep();
            }
        });
    }

    /**
     * Determines whether the egg should hatch based on how long it has been left on the ground.
     * The egg only hatches if it has been on the ground (not in inventory) for at least 3 turns.
     *
     * @param location The current map location of the egg.
     * @return true if the egg should hatch, false otherwise.
     */
    @Override
    public boolean hatchConditionMet(Location location) {
        if (location.getActor() != null) {
            groundCounter = 0;
            return false;
        }
        groundCounter++;
        return groundCounter >= 3;
    }

    /**
     * Consumes the egg and applies its effect to the actor.
     * Increases the actor's maximum health by 10 points.
     *
     * @param actor The actor consuming the egg.
     */
    @Override
    public void consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 10);
    }
}