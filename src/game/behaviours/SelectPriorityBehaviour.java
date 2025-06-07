package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;

public class SelectPriorityBehaviour implements SelectBehaviour {
    @Override
    public Action selectBehaviour(Map<Integer, Behaviour> behaviours, Actor actor, GameMap map) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(actor, map);
            if (action != null) {
                return action;
            }
        }
        return null;
    }
}
