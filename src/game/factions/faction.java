package game.factions;

import game.Affectionable;

import java.util.ArrayList;

public abstract  class faction {
    private ArrayList members;
    private Integer standing;
    public void faction(ArrayList<Affectionable> affectionables) {
        this.members = affectionables;
        this.standing = 0;
    }

    public ArrayList getMembers() {
        return this.members;
    }

    public Integer getStanding() {
        return this.standing;
    }

    public abstract void factionEffect();

    public void setMember(Affectionable member) {
        this.members.add(member);
    }
}
