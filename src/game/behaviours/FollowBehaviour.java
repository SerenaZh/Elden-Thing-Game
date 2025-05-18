package game.behaviours;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.Status;

/**
 * A behavior that causes an actor to follow another actor marked as followable (e.g., the player).
 * The actor will check adjacent tiles for a followable target and move toward them.
 * Once a target is locked, it continues following until the target is removed from the map.
 * @author 2099 Team
 * Modified by Khushi R
 */
public class FollowBehaviour implements Behaviour {

    /**
     * The current target being followed.
     */
    private Actor target;

    /**
     * Determines and returns a move action for the actor to follow a nearby actor with the HOSTILE_TO_ENEMY status.
     * The behavior locks onto the first followable actor found in adjacent tiles and continues following it.
     *
     * @param actor the actor performing the behavior
     * @param map   the game map
     * @return a MoveActorAction to follow the target if applicable, or null if no action is required
     */
    @Override
    public MoveActorAction getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            Location dest = exit.getDestination();
            if (dest.containsAnActor()) {
                Actor candidate = dest.getActor();
                if (candidate.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    target = candidate;
                    break;
                }
            }
        }

        // Move toward the target if still on the map
        if (target != null && map.contains(target)) {
            Location targetLoc = map.locationOf(target);
            for (Exit exit : here.getExits()) {
                if (exit.getDestination().equals(targetLoc)) {
                    return new MoveActorAction(exit.getDestination(), exit.getName(), exit.getHotKey());
                }
            }
        }

        return null;
    }
}
