package game.factions;

import edu.monash.fit2099.engine.actors.Actor;
import game.Capabilities;
import game.items.Buyable;
import game.items.weapons.WeaponItem;

import java.util.ArrayList;

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
