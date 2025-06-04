package game.factions;
import game.Capabilities;
import game.items.weapons.WeaponItem;

public class CreatureFaction extends Faction {
    public CreatureFaction() {
        super(Capabilities.CREATURE);
    }

    @Override
    public void factionEffect(WeaponItem weapon) {
        decreaseStanding(1);
    }

    public boolean shouldAvoidPlayer() {
        return getStanding() < 2;
    }
}
