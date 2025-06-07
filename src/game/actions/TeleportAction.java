package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class TeleportAction extends Action {
    private final GameMap destinationMap;
    private final int destX;
    private final int destY;

    public TeleportAction(GameMap destinationMap, int destX, int destY) {
        this.destinationMap = destinationMap;
        this.destX = destX;
        this.destY = destY;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        destinationMap.at(destX, destY).addActor(actor);
        return actor + " teleports to a new region!";
    }
    @Override
    public String menuDescription(Actor actor) {
        return actor + " enters the teleportation circle";
    }
}
