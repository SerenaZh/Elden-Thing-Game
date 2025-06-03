package game.factions;
import game.Capabilities;
import game.items.weapons.WeaponItem;

public class MerchantFaction extends Faction {
    public MerchantFaction(Capabilities capability) {
        super(capability);
        FactionStandingManager.allFactions.put(capability,this);
    }

    @Override
    public void factionEffect(WeaponItem weapon) {
        weapon.modifyCost(2);
    }
}
