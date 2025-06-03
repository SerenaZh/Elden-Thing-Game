package game.factions;

import game.Capabilities;

import java.util.HashMap;
import java.util.Map;

public class FactionStandingManager {
    public static Map<Capabilities, Faction> allFactions = new HashMap<>();

    public FactionStandingManager() {
        allFactions.put(Capabilities.MERCHANT,new MerchantFaction(Capabilities.MERCHANT));
        allFactions.put(Capabilities.CREATURE,new MerchantFaction(Capabilities.CREATURE));
        allFactions.put(Capabilities.ENEMY,new MerchantFaction(Capabilities.ENEMY));

    }
    public Faction getFaction(Capabilities factionKey) {
        return allFactions.get(factionKey);
    }

    public void addFaction(Faction faction) {
         for(Capabilities existingFactionKey : allFactions.keySet() ) {
             if (allFactions.get(existingFactionKey).getID() == faction.getID()){
                 return;
             }
         }
         allFactions.put(faction.getID(), faction);
    }
}
