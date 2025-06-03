package game.factions;

import edu.monash.fit2099.engine.actors.Actor;
import game.Capabilities;
import game.items.weapons.WeaponItem;

public class CreatureFaction extends Faction {
    public CreatureFaction(Capabilities capability) {
        super(capability);
        FactionStandingManager.allFactions.put(capability,this);
    }

    public void factionEffect(Actor actor) {
        actor.heal(10);
    }

    @Override
    public void factionEffect(WeaponItem weaponItem) {
        return;
    }

}
