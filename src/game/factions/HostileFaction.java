package game.factions;
import game.Capabilities;
import game.items.weapons.WeaponItem;

public class HostileFaction extends Faction {
    public HostileFaction() {
        super(Capabilities.HOSTILE);
    }

    @Override
    public void factionEffect(WeaponItem weapon) {
    }
}
