package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Capabilities;

import java.util.List;

/**
 * A magical plant that exists in this world
 * Very cool, heals you and restores your stamina
 *
 * @author Serena Zhou
 */
public class Inheritree extends Ground implements Planting {
    /**
     * Constructor of the Inheritree
     */
    public Inheritree(){
        super('t', "Inheritree");
        this.addCapability(Capabilities.BLESSED_BY_GRACE);
    }

    /**
     * The tick method for the Inheritree, allows
     * it to enjoy the joy of time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        super.tick(location);
        // Gets surrounding locations
        // Check each surrounding location for Actors then apply the effects
        List<Exit> exits = location.getExits();
        for (Exit exit: exits){
            Location l = exit.getDestination();

            if (l.getGround().hasCapability(Capabilities.CURSED)) {
                l.setGround(new Soil());
            }

            if ( l.containsAnActor() ){
                Actor actor = l.getActor();

                actor.heal(5);
                if (actor.hasAttribute(BaseActorAttributes.STAMINA)) {
                    actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE, 5);
                }
            }
        }
    }

    /**
     * Plants the inheritree onto the ground the actor is standing on
     * @param actor that is doing the planting
     * @param map of the Game
     * @return boolean if the Inheritree has been planted or not
     */
    @Override
    public boolean applyPlant(Actor actor, GameMap map) {
        int staminaCost = 25;
        if (actor.getAttribute(BaseActorAttributes.STAMINA) < staminaCost) {
            return false;
        }
        map.locationOf(actor).setGround(this);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
        return  true;
    }
}
