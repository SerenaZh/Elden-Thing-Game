package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Affectionable;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.factions.Faction;
import game.factions.FactionStandingManager;
import game.items.weapons.WeaponItem;

/**
 * Class representing an action to attack
 * Note that the attacker must have a weapon, e.g.,
 * an intrinsic weapon or a weapon item.
 * Otherwise, the execute method will throw an error.
 * Created by: the FIT2099 Teaching Team
 * @author Adrian Kristanto
 * Modified by: Serena Zhou
 */
public class AttackAction extends Action implements Affectionable {

    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor with intrinsic weapon as default
     *
     * @param target the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Executes the attack action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String of the result
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        affectFaction(actor);

        String result = weapon.attack(actor, target, map);
        if (!target.isConscious()) {
            result += "\n" + target.unconscious(actor, map);
        }

        return result;
    }

    /**
     * Shows the text option to be displayed on the terminal
     * @param actor The actor performing the action.
     * @return String to be printed
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }

    public void affectFaction(Actor actor) {
        //Checking if target is part of the creature faction and that the player is attacking.
        if (target.hasCapability(Capabilities.CREATURE) && actor.getDisplayChar()=='@'){
            Faction creatureFaction = FactionStandingManager.allFactions.get(Capabilities.CREATURE);
            creatureFaction.factionEffect((NonPlayableActor) target);
        }

        if (actor.hasCapability(Capabilities.HOSTILE) && actor.getDisplayChar()=='@'){
            Faction hostile = FactionStandingManager.allFactions.get(Capabilities.HOSTILE);
            hostile.factionEffect((NonPlayableActor) actor);
        }
    }
}
