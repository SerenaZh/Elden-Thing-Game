package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actor.Status;
import game.behaviours.FollowBehaviour;
import game.behaviours.LayEggBehaviour;
import game.items.egg.GoldenEgg;

/**
 * Class representing the Golden Beetle NPC
 * @author Khushi R
 */
public class GoldenBeetle extends NonPlayableActor implements ActorFactory {
    /**
     * Constructor for GoldenBeetle
     */
    public GoldenBeetle() {
        super("Golden Beetle", 'b', 25);
        this.behaviours.put(1, new LayEggBehaviour(new GoldenEgg(this)));
    }

    /**
     * Creates a new instance of this class
     * @return Actor a new instance
     */
    @Override
    public Actor createNewInstance() {
        return new GoldenBeetle();
    }

    /**
     * Returns a list of actions that can be performed on this beetle by another actor.
     * If the other actor is hostile, they are allowed to consume the beetle.
     *
     * @param otherActor the actor interacting with this beetle
     * @param direction  the direction of the beetle relative to the other actor
     * @param map        the game map
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(999, new FollowBehaviour(otherActor));
            actions.add(new ConsumeAction(this, "+15 HP, +1000 Runes"));
        }
        return actions;
    }
}
