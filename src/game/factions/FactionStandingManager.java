package game.factions;
import game.Capabilities;
import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a manager for Factions
 * Author: Aryan M
 **/
public class FactionStandingManager {
    /**
     * Hashmap containing each faction ID (represented by capabilities) and their corresponding faction object
     **/
    public static Map<Capabilities, Faction> allFactions = new HashMap<>();

    /**
     * Initialising FactionStandingManager with all factions
     **/
    public FactionStandingManager() {
        allFactions.put(Capabilities.MERCHANT,new MerchantFaction());
        allFactions.put(Capabilities.CREATURE,new CreatureFaction());
        allFactions.put(Capabilities.HOSTILE,new HostileFaction());
    }
    /**
     * Method to retrieve a particular faction
     * @param factionKey representing the faction to be retrieved
     * @return Faction object which was requested
     **/
    public Faction getFaction(Capabilities factionKey) {
        return allFactions.get(factionKey);
    }
    /**
     * Method to add a particular faction
     * @param faction representing the faction to be added
     **/
    public void addFaction(Faction faction) {
         for(Capabilities existingFactionKey : allFactions.keySet() ) {
             if (allFactions.get(existingFactionKey).getID() == faction.getID()){
                 return;
             }
         }
         allFactions.put(faction.getID(), faction);
    }
}
