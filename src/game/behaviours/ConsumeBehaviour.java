package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.Capabilities;
import game.actions.TransformAction;
import game.actor.npc.Transformable;
import game.ground.Soil;

public class ConsumeBehaviour implements Behaviour {
    private final Transformable transformable;

    public ConsumeBehaviour(Transformable transformable) {
        this.transformable = transformable;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Ground ground = map.locationOf(actor).getGround();
        if (ground.hasCapability(Capabilities.CONSUMABLE)) {
            map.locationOf(actor).setGround(new Soil());

            return new TransformAction(transformable);
        }

        return null;
    }
}
