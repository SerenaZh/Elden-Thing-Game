package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actor.Status;
import game.behaviours.FollowBehaviour;
import game.behaviours.LayEggBehaviour;
import game.behaviours.SelectBehaviour;
import game.behaviours.SelectPriorityBehaviour;
import game.items.GoldenEgg;

/**
 * Class representing the Golden Beetle NPC
 * @author Khushi R
 */
public class GoldenBeetle extends NonPlayableActor implements ActorFactory {
    public GoldenBeetle() {
        this(new SelectPriorityBehaviour());
    }
    /**
     * Constructor for GoldenBeetle
     */
    public GoldenBeetle(SelectBehaviour selector) {
        super("Golden Beetle", 'b', 25, selector);
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
            actions.add(new ConsumeAction(this, "+15 HP, +1000 Runes"));
            this.behaviours.put(999, new FollowBehaviour(otherActor));
        }
        return actions;
    }
}
