package game.actor;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.BareFist;
import game.actor.npc.NonPlayableActor;
import game.boss.Branch;
import game.boss.Leaf;
import game.boss.TreePart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A stationary boss that either attacks nearby actors or grows new branches/leaves.
 */
public class BedOfChaos extends NonPlayableActor {

    private final List<TreePart> treeParts = new ArrayList<>();
    private final Random rand = new Random();
    private final int baseDamage = 25;
    private final int accuracy = 75;

    public BedOfChaos() {
        super("Bed of Chaos", 'T', 1000);
        this.setIntrinsicWeapon(new BareFist(baseDamage, "smacks", accuracy));
    }

    /**
     * Called every turn by the engine.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        boolean attacked = attackNearby(map, display);

        if (!attacked) {
            grow(display);
        }

        for (TreePart part : treeParts) {
            part.tick(this);
        }

        return new DoNothingAction();
    }

    /**
     * Attacks the first actor it finds in surrounding tiles with full attack power.
     */
    private boolean attackNearby(GameMap map, Display display) {
        Location here = map.locationOf(this);
        for (Exit exit : here.getExits()) {
            Location dest = exit.getDestination();
            if (dest.containsAnActor()) {
                Actor target = dest.getActor();
                if (target != null && target != this && target.isConscious()) {
                    int totalDamage = calculateTotalAttack();
                    this.setIntrinsicWeapon(new BareFist(totalDamage, "smacks", accuracy));
                    display.println(this + " smacks " + target + " for " + totalDamage + " damage");
                    target.hurt(totalDamage);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Grows a new Branch or Leaf at the top level.
     */
    private void grow(Display display) {
        TreePart newPart = rand.nextBoolean() ? new Branch() : new Leaf();
        treeParts.add(newPart);
        display.println("Bed of Chaos is growing...");
        display.println("it grows a " + newPart + "...");
    }

    /**
     * Calculates total attack based on all TreeParts.
     */
    public int calculateTotalAttack() {
        int total = baseDamage;
        for (TreePart part : treeParts) {
            total += part.getAttackBonus();
        }
        return total;
    }
}

