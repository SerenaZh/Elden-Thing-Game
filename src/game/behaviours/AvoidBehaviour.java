package game.behaviours;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.Player;

public class AvoidBehaviour implements Behaviour {

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

    private boolean isCardinalAdjacent(Location loc1, Location loc2) {
        int dx = loc1.x() - loc2.x();
        int dy = loc1.y() - loc2.y();
        return (Math.abs(dx) == 1 && dy == 0) || (dx == 0 && Math.abs(dy) == 1);
    }
}
