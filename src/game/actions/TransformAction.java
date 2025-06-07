package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actor.npc.Transformable;

/**
 * Transforms the transformable into something else
 * Only takes in Transformable objects
 *
 * @author Serena Zhou
 */
public class TransformAction extends Action {
    /**
     * The object to be transformed
     */
    private Transformable transformable;

    /**
     * Constructor
     * @param transformable
     */
    public TransformAction(Transformable transformable) {
        this.transformable = transformable;
    }

    /**
     * Executes the transform action for the transformable
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to be displayed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Actor transformed = transformable.transform(map);
        return actor.toString() + " has transformed into " + transformed.toString();
    }

    /**
     * Menu description to be displayed so the player can select
     * @param actor The actor performing the action.
     * @return Menu description String
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " transforms into ";
    }
}
