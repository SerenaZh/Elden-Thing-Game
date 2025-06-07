package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import game.BareFist;
import game.actions.ListenAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.MonologueCapable;
import game.behaviours.SelectPriorityBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Guts is a berserk NPC who attacks all conscious actors with HP > 50.
 *
 * @author Mohammed A
 */
public class Guts extends NonPlayableActor implements MonologueCapable {

    private final Random rand = new Random();

    public Guts() {
        super("Guts", 'g', 500, new SelectPriorityBehaviour());
        this.setIntrinsicWeapon(new BareFist());
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Guts’ dialogue when listened to, varies depending on the listener's HP.
     */
    @Override
    public List<String> generateMonologuePool(Actor listener, GameMap map) {
        List<String> pool = new ArrayList<>();
        Integer hp = listener.getAttribute(BaseActorAttributes.HEALTH);

        if (hp != null && hp < 50) {
            pool.add("WEAK! TOO WEAK TO FIGHT ME!");
        } else {
            pool.add("RAAAAGH!");
            pool.add("I’LL CRUSH YOU ALL!");
        }

        return pool;
    }

    /**
     * Allows the player to interact with Guts but only Listen, not attack.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = super.allowableActions(otherActor, direction, map);
        actions.add(new ListenAction(this));
        return actions;
    }
}
