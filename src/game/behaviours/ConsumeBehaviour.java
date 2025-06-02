package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;
import game.ground.plants.Consumable;

public class ConsumeBehaviour implements Behaviour {
    private Consumable consumable;

    public ConsumeBehaviour(Consumable consumable) {
        this.consumable = consumable;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {


        return null;
    }
}
