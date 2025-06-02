package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actor.npc.Transformable;

public class TransformAction extends Action {
    private Transformable transformable;

    public TransformAction(Transformable transformable) {
        this.transformable = transformable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        transformable.transform(map);
        return actor.toString() + " has transformed into ";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " transforms into ";
    }
}
