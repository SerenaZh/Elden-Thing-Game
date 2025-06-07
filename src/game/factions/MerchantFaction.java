package game.factions;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.items.weapons.WeaponItem;

/**
 * Class representing a Hostile Faction
 * Author: Aryan M
 **/
public class MerchantFaction extends Faction {
    public MerchantFaction() {
        super(Capabilities.MERCHANT);
    }

    /**
     *Method which enacts the WeaponItem effect of this faction
     * @param weapon which is being affected
     **/
    @Override
    public void factionEffect(WeaponItem weapon) {
        weapon.modifyCost(2);
    }

    /**
     *Method which enacts the NPC effect of this faction
     * @param actor npc which is being affected
     **/
    @Override
    public void factionEffect(NonPlayableActor actor) {
        //
    }

}
