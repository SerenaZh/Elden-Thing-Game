package game.factions;

import java.util.HashMap;
import java.util.Map;

public class FactionStandingManager {
    private Map<Faction, Integer> factionStanding = new HashMap<>();
    private static final Integer standingCiel = 10;
    private static final Integer getStandingFloor = 0;

     public void increaseStanding(Faction faction, int amount) {
         if (factionStanding.get(faction)+amount < standingCiel) {
             factionStanding.put(faction, factionStanding.get(faction) + amount);
             return;
         }
         factionStanding.put(faction, 10);
     }

    public void decreaseStanding(Faction faction, int amount) {
        if (factionStanding.get(faction)-amount > getStandingFloor) {
            factionStanding.put(faction, factionStanding.get(faction) - amount);
            return;
        }
        factionStanding.put(faction, 0);
    }

    public void addFaction(Faction faction) {
         for(Faction existingFaction : factionStanding.keySet() ) {
             if (existingFaction.getID() == faction.getID()){
                 return;
             }
         }
         factionStanding.put(faction, 0);
    }

}
