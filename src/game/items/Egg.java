package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actor.npc.ActorFactory;

public class Egg extends Item {
    private ActorFactory actorFactory;

    tick(){
        actorFactory.createNewInstance();
    }

}
