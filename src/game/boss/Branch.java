package game.boss;

import game.actor.BedOfChaos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A branch that can grow other branches or leaves. Adds recursive attack bonus.
 */
public class Branch extends TreePart {

    private final List<TreePart> children = new ArrayList<>();
    private final Random rand = new Random();

    @Override
    public int getAttackBonus() {
        int bonus = 3;
        for (TreePart child : children) {
            bonus += child.getAttackBonus();
        }
        return bonus;
    }

    @Override
    public void tick(BedOfChaos boss) {
        // 50% chance to grow a new child
        if (rand.nextBoolean()) {
            TreePart newPart = rand.nextBoolean() ? new Branch() : new Leaf();
            children.add(newPart);
            System.out.println("Branch is growing...");
            System.out.println("it grows a " + newPart + "...");
        }

        for (TreePart child : children) {
            child.tick(boss);
        }
    }

    @Override
    public String toString() {
        return "Branch";
    }
}
