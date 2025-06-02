package game.ground.plants;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.ground.Plant;

import java.util.List;

/**
 * A plant that exists in the world that is pretty
 * dangerous if you're not careful
 * Sucks the life out of you
 * @author Serena Zhou
 */
public class Bloodrose extends Ground implements Plant {
    /**
     * Constructor of the Bloodrose
     */
    public Bloodrose(){
        super('w', "Bloodrose");
    }

    /**
     * The tick method for the Bloodrose, allows it to
     * enjoy the joy of time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        super.tick(location);

        Actor actorHere = location.getActor();
        if (actorHere != null) {
            actorHere.hurt(5);
        }

        List<Exit> exits = location.getExits();
        for (Exit exit: exits){
            Location l = exit.getDestination();
            if ( l.containsAnActor() ){
                Actor actor = l.getActor();
                actor.hurt(10);
            }
        }
    }

    /**
     * Plants the Bloodrose onto the ground actor is standing on
     * @param actor that is doing the planting
     * @param map of the Game
     * @return boolean if the Bloodrose has been planted or not
     */
    @Override
    public boolean applyPlant(Actor actor, GameMap map) {
        int staminaCost = 75;
        if (actor.getAttribute(BaseActorAttributes.STAMINA) < staminaCost) {
            return false;
        }
        map.locationOf(actor).setGround(this);
        actor.modifyAttribute(BaseActorAttributes.STAMINA, ActorAttributeOperations.DECREASE, staminaCost);
        return true;
    }
}
