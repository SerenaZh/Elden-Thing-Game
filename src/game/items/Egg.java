package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.npc.ActorFactory;

/**
 * An abstract class representing an egg item in the game.
 * Eggs can hatch into actors if specific conditions are met while on the ground,
 * and may be consumed for certain effects if held in an actor's inventory.
 *
 * @author Sandeesa R & Khushi R
 */
public abstract class Egg extends Item {

    /**
     * A factory used to generate the actor this egg hatches into.
     */
    private final ActorFactory actorFactory;

    /**
     * Constructs a new Egg item.
     *
     * @param name          the name of the egg
     * @param displayChar   the character used to represent the egg on the map
     * @param actorFactory  the factory responsible for creating the actor that this egg hatches into
     */
    public Egg(String name, char displayChar, ActorFactory actorFactory) {
        super(name, displayChar, true);
        this.actorFactory = actorFactory;
    }

    /**
     * Called every game turn while the egg is on the ground.
     * If no actor is present on this location and the hatching condition is met,
     * the egg is removed and the corresponding actor is added to the map.
     *
     * @param location the current location of the egg on the map
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (location.getActor() == null && hatchConditionMet(location)) {
            location.removeItem(this);
            Actor hatched = actorFactory.createNewInstance();
            location.addActor(hatched);
        }
    }

    /**
     * Determines whether the egg should hatch based on the conditions at the given location.
     *
     * @param location the current location of the egg
     * @return true if the egg should hatch, false otherwise
     */
    public abstract boolean hatchConditionMet(Location location);

    /**
     * Called when the egg is consumed by an actor.
     * This method can be overridden to implement custom effects such as healing or stamina gain.
     *
     * @param actor the actor consuming the egg
     */
    public void consume(Actor actor) {
        // Override in subclasses to define behavior on consumption
    }

    /**
     * Gets the actor factory used to create the hatched actor.
     *
     * @return the actor factory associated with this egg
     */
    public ActorFactory getActorFactory() {
        return actorFactory;
    }
}
