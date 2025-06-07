package game.actions.farming;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ground.Hole;

/**
 * Class representing the action to dig holes
 *
 * @author Serena Zhou
 */
public class ShovelAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).setGround(new Hole());
        return actor.toString() + " has dug a new hole!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " digs a hole";
    }
}
