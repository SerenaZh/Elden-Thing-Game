package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Map;

public interface SelectBehaviour {
    Action selectBehaviour(Map<Integer, Behaviour> behaviours, Actor actor, GameMap map);
}
