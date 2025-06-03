package game.factions;

import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;

import java.util.HashMap;
import java.util.Map;

public class FactionStandingManager {
    private Map<Capabilities, Faction> factionStanding = new HashMap<>();

    public int getFactionStanding(Capabilities factionKey) {
        return factionStanding.get(factionKey).getStanding();
    }




    public void addFaction(Faction faction) {
         for(Capabilities existingFactionKey : factionStanding.keySet() ) {
             if (factionStanding.get(existingFactionKey).getID() == faction.getID()){
                 return;
             }
         }
         factionStanding.put(faction.getID(), faction);
    }

}
