package game.actor;

import edu.monash.fit2099.engine.actions.ActionList;
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

    @Override
    public void tick(Location location) {
        super.tick(location);
        boolean attacked = attackNearby(location.map());
        if (!attacked) {
            grow();
        }

        for (TreePart part : treeParts) {
            part.tick(this);
        }
    }

    /**
     * Attacks the first actor it finds in surrounding tiles with full attack power.
     */
    private boolean attackNearby(GameMap map) {
        Location here = map.locationOf(this);
        for (Exit exit : here.getExits()) {
            Location dest = exit.getDestination();
            if (dest.containsAnActor()) {
                Actor target = dest.getActor();
                if (target != null && target != this) {
                    int totalDamage = calculateTotalAttack();
                    this.setIntrinsicWeapon(new BareFist(totalDamage, "smacks", accuracy));
                    ActionList actions = target.allowableActions(this, exit.getName(), map);
                    new Display().println(this + " " + this.getIntrinsicWeapon().verb() + " " + target + " for " + totalDamage + " damage");
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
    private void grow() {
        TreePart newPart = rand.nextBoolean() ? new Branch() : new Leaf();
        treeParts.add(newPart);
        System.out.println("Bed of Chaos is growing...");
        System.out.println("it grows a " + newPart + "...");
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

    @Override
    public String toString() {
        return super.toString();
    }
}

