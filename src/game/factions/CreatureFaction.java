package game.factions;
import edu.monash.fit2099.engine.actors.Behaviour;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.behaviours.AvoidBehaviour;
import game.items.weapons.WeaponItem;

/**
 * Class representing a creature faction
 * Author: Sandeesa R
 **/
public class CreatureFaction extends Faction {
    /**
     * Initialising CreatureFaction
     **/
    public CreatureFaction() {
        super(Capabilities.CREATURE);
    }

    /**
     *Method which enacts the WeaponItem effect of this faction
     * @param weapon which is being affected
     **/
    @Override
    public void factionEffect(WeaponItem weapon) {//
    }

    /**
     *Method which enacts the NPC effect of this faction
     * @param target npc which is being affected
     **/
    @Override
    public void factionEffect(NonPlayableActor target) {
        if(this.shouldAvoidPlayer()){
             target.addBehaviour(998,new AvoidBehaviour());
            return;
        }
        else if (target.behaviours.containsKey(998)) {
            Behaviour avoidBehaviour = target.behaviours.get(998);
            target.removeBehaviour(998);
        }

    }

    /**
     *Method to check if standing value warrents the enactment of factionEffect
     * @return boolean which confirms if faction effect must take place
     **/
    public boolean shouldAvoidPlayer() {
        return this.getStanding() < 2;
    }
}
