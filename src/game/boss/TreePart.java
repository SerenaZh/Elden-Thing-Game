package game.boss;

import game.actor.BedOfChaos;

/**
 * Abstract class representing a part of the Bed of Chaos (e.g., Branch, Leaf).
 */
public abstract class TreePart {

    /**
     * Returns the total attack bonus provided by this part.
     * Branches include recursive bonuses from their subparts.
     *
     * @return attack bonus
     */
    public abstract int getAttackBonus();

    /**
     * Defines how this part behaves each tick.
     * E.g., Branch may grow more parts, Leaf may heal the boss.
     *
     * @param boss the Bed of Chaos instance that owns this part
     */
    public abstract void tick(BedOfChaos boss);
}
