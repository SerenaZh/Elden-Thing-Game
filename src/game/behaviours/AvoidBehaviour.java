package game.behaviours;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actor.Player;

public class AvoidBehaviour implements Behaviour {

    private final Player player;

    public AvoidBehaviour(Player player) {
        this.player = player;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!map.contains(player) || !map.contains(actor))
            return null;

        Location npcLocation = map.locationOf(actor);
        Location playerLocation = map.locationOf(player);

        if (!isCardinalAdjacent(npcLocation, playerLocation)) {
            return null;
        }

        for (Exit exit : npcLocation.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor) && !isCardinalAdjacent(destination, playerLocation)) {
                return new MoveActorAction(destination, exit.getName());
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
