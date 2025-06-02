package game.actor.npc.creatures;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.RazorWings;
import game.actor.Status;
import game.actor.npc.NonPlayableActor;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;

public class AeonianButterfly extends NonPlayableActor {
    public static final int attackRank = 1;
    public static final int followRank = 999;

    public AeonianButterfly() {
        super("Aeonian Butterfly", 'A', 120);
        this.setIntrinsicWeapon(new RazorWings());
        this.behaviours.put(attackRank, new AttackBehaviour());
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            this.behaviours.put(followRank, new FollowBehaviour(otherActor));
        }
        return actions;
    }
}
