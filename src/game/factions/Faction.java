package game.factions;

import edu.monash.fit2099.engine.actors.Actor;
import game.Capabilities;

public abstract  class Faction {
    private Capabilities factionID;
    public Faction(Capabilities factionID) {
        this.factionID = factionID;
    }

    public Capabilities getID() {
        return factionID;
    }

    public Integer getStanding() {
        return this.standing;
    }

    public abstract void factionEffect(Actor actor);
}
