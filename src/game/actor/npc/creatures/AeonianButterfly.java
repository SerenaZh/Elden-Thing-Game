package game.actor.npc.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RazorWings;
import game.actor.Status;
import game.actor.npc.ActorFactory;
import game.actor.npc.NonPlayableActor;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;

/**
 * The class for a hostile creature Aeonian Butterfly
 *
 * @author Serena Zhou
 */
public class AeonianButterfly extends NonPlayableActor {
    /**
     * Magic number for attack priority
     */
    private static final int attackRank = 1;
    /**
     * Magic number for follow priority
     */
    private static final int followRank = 999;

    /**
     * Constructor
     */
    public AeonianButterfly() {
        super("Aeonian Butterfly", 'A', 120);
        this.setIntrinsicWeapon(new RazorWings());
        this.behaviours.put(attackRank, new AttackBehaviour());
    }

    /**
     * Gets all allowable actions
     * @param otherActor the Actor that might be performing the action
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(followRank, new FollowBehaviour(otherActor));
        }
        return actions;
    }
}
