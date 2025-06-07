package game.factions;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.behaviours.AvoidBehaviour;
import game.items.weapons.WeaponItem;

/**
 * Class representing a Hostile Faction
 * Author: Aryan M and Sandeee R
 **/
public class HostileFaction extends Faction {
    /**
     * Initialising Hostile Faction
     **/
    public HostileFaction() {
        super(Capabilities.HOSTILE);
    }

    /**
     *Method which enacts the WeaponItem effect of this faction
     * @param weapon which is being affected
     **/
    @Override
    public void factionEffect(WeaponItem weapon) {
        //
    }

    /**
     *Method which enacts the NPC effect of this faction
     * @param attacker npc which is being affected
     **/
    @Override
    public void factionEffect(NonPlayableActor attacker) {
        if(this.shouldAvoid()){
            attacker.addBehaviour(2,new AvoidBehaviour());
        }
        if(attacker.behaviours.containsKey(2) && !this.shouldAvoid()){
            attacker.behaviours.remove(2);
        }
    }

    /**
     *Method to determine if the npc should avoid the player
     * @return  boolean which confirms if the npc should avoid the player
     **/
    private boolean shouldAvoid(){
        if(this.getStanding()>8){
            return true;
        }
        return false;
    }
}
