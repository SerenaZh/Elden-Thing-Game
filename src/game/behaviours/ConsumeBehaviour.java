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

/**
 * Behaviour of an actor that once it consumes a consumable
 * ground, it will have the ability to transform into a
 * different creature
 *
 * @author Serena Zhou
 */
public class ConsumeBehaviour implements Behaviour {
    /**
     * The transformable that will be doing the action
     */
    private final Transformable transformable;

    /**
     * Constructor
     * @param transformable
     */
    public ConsumeBehaviour(Transformable transformable) {
        this.transformable = transformable;
    }

    /**
     * Gets the actions that the actor can do
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return a list of actions that the actor can execute
     */
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
