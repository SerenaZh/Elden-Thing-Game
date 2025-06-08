package game;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * Class representing an intrinsic weapon called a bare fist.
 * This intrinsic weapon deals 25 damage points with a 50% chance
 * to hit the target.
 * @author Adrian Kristanto
 * Modified by Serena Zhou, Mohammed A
 */
public class BareFist extends IntrinsicWeapon {
    /**
     * Constructor for BareFist
     */
    public BareFist() {
        super(25, "punches", 50);
    }


    /**
     * Custom constructor for configurable damage, verb, and hit rate (used by Bed of Chaos).
     *
     * @param damage the amount of damage
     * @param verb the attack description
     * @param hitRate the hit chance
     */
    public BareFist(int damage, String verb, int hitRate) {
        super(damage, verb, hitRate);
    }
}

