package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;

public class TeleportationCircle extends Ground {
    private final GameMap destinationMap;
    private final int destX, destY;

    public TeleportationCircle(GameMap destinationMap, int x, int y) {
        super('A', "Teleportation Circle");
        this.destinationMap = destinationMap;
        this.destX = x;
        this.destY = y;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new TeleportAction(destinationMap, destX, destY));
        return actions;
    }
}

