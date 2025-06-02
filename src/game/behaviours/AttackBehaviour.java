package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;

import java.util.List;

/**
 * A Behaviour that makes an Actor attack nearby actors with HP > 50.
 *
 * @author Mohammed A
 */
public class AttackBehaviour implements Behaviour {
    /**
     * Returns an attack action they can do if requirements are met
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return Action that may happen or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        List<Exit> exits = here.getExits();

        for (Exit exit : exits) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()) {
                Actor target = destination.getActor();
                return new AttackAction(target, exit.getName());
            }
        }

        return null;
    }
}

