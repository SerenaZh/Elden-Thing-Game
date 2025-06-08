package game.factions;
import game.Capabilities;
import game.actor.npc.NonPlayableActor;
import game.items.weapons.WeaponItem;

/**
 * Class representing a faction
 * Author: Aryan M
**/

public abstract class Faction {
    /**
     * Enum representing faction (e.g. MERCHANT, HOSTILE ETC)
     **/
    private final Capabilities factionID;
    /**
     *int representing the standing of player with this faction
     **/
    private int standing;
    /**
     *int representing the max standing cap
     **/
    private static final Integer standingCiel = 10;
    /**
     *int representing the min possible standing
     **/
    private static final Integer getStandingFloor = 0;

    /**
     *Init for Faction Class
     *@param factionID representing the faction
     **/
    public Faction(Capabilities factionID) {
        this.factionID = factionID;
        this.standing=5;
    }

    /**
     *method to get ID for this faction
     *@return Enum representing the ID
     **/
    public Capabilities getID() {
        return factionID;
    }

    /**
     *method to get standing of faction
     *@return int representing the standing of faction
     **/
    public int getStanding() {
        return this.standing;
    }

    /**
     *method to increase standing of faction
     *@param  amount representing the standing increase of faction
     **/
    public void increaseStanding(int amount) {
        if (this.standing+amount< standingCiel) {
            this.standing+=amount;
            return;
        }
        this.standing=standingCiel;
    }

    /**
     *method to decrease standing of faction
     *@param  amount representing the standing decrease of faction
     **/
    public void decreaseStanding(int amount) {
        if (this.standing-amount> getStandingFloor) {
            this.standing-=amount;
            return;
        }
        this.standing=getStandingFloor;
    }

    /**
     *method which determins/enact the effect of faction standing; when it affects a weapon
     *@param  weapon representing the weapon being affected
     **/
    public abstract void factionEffect(WeaponItem weapon);
    /**
     *method which determines/enact the effect of faction standing; when it affects an NPC
     *@param  target representing the weapon being affected
     **/
    public abstract void factionEffect(NonPlayableActor target);



    /**
     *Method to represent a faction in str format
     *@return string describing the faction
     **/
    @Override
    public String toString() {
        return this.factionID.toString()+": "+this.standing;
    }
}
