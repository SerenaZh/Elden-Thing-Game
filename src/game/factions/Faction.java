package game.factions;

import edu.monash.fit2099.engine.actors.Actor;
import game.Capabilities;
import game.items.weapons.WeaponItem;

public abstract class Faction {
    private Capabilities factionID;
    private int standing;
    private static final Integer standingCiel = 10;
    private static final Integer getStandingFloor = 0;

    public Faction(Capabilities factionID) {
        this.factionID = factionID;
        this.standing=5;
    }

    public Capabilities getID() {
        return factionID;
    }

    public int getStanding() {
        return this.standing;
    }

    public void increaseStanding(int amount) {
        if (this.standing+amount< standingCiel) {
            this.standing+=amount;
            return;
        }
        this.standing=standingCiel;
    }

    public void decreaseStanding(int amount) {
        if (this.standing-amount> getStandingFloor) {
            this.standing-=amount;
            return;
        }
        this.standing=getStandingFloor;
    }

    public abstract void factionEffect(WeaponItem weapon);



    @Override
    public String toString() {
        return this.factionID.toString()+": "+this.standing;
    }
}
