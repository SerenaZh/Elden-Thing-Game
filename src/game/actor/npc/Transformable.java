package game.actor.npc;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Transformable {
    public Actor transform(GameMap map);
}
