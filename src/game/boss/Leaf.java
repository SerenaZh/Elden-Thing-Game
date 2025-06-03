package game.boss;

import game.actor.BedOfChaos;

/**
 * A leaf that grows from the Bed of Chaos. Provides +1 damage and heals the boss each tick.
 */
public class Leaf extends TreePart {

    @Override
    public int getAttackBonus() {
        return 1;
    }

    @Override
    public void tick(BedOfChaos boss) {
        boss.heal(5); // heal boss by 5
    }

    @Override
    public String toString() {
        return "Leaf";
    }
}
