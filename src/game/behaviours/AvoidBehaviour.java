package game.behaviours;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A Behaviour that allows an Actor to avoid the player character.
 * Author: Sandeesa R
 **/
public class AvoidBehaviour implements Behaviour {

    /**
     * Determines the action to perform for avoidance.
     * @param actor the Actor enacting the behaviour
     * @param map   the GameMap containing the actor
     * @return an Action to move away from the player if adjacent, or null otherwise
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for(Exit exit : map.locationOf(actor).getExits()){
            if(exit.getDestination().containsAnActor()){
                if(exit.getDestination().getActor().getDisplayChar()=='@'){
                    return exit.getDestination().getMoveAction(actor,"around",exit.getHotKey());
                }
            }
        }
        return null;
    }

    /**
     * Checks if two locations are adjacent in a cardinal direction (N, S, E, W).
     *
     * @param loc1 the first location
     * @param loc2 the second location
     * @return true if loc1 is adjacent to loc2 in a cardinal direction, false otherwise
     */
    private boolean isCardinalAdjacent(Location loc1, Location loc2) {
        int dx = loc1.x() - loc2.x();
        int dy = loc1.y() - loc2.y();
        return (Math.abs(dx) == 1 && dy == 0) || (dx == 0 && Math.abs(dy) == 1);
    }
}
