package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Affectionable;
import game.Capabilities;
import game.factions.Faction;
import game.factions.FactionStandingManager;


/**
 *Class representing the player giving something to a npc
 *
 * Author: Aryan M
 **/

public class GiveAction extends Action implements Affectionable {
    /**
     *Item being given
     **/
    private Item item;
    /**
     *The target who is receiving item
     **/
    private Actor target;

    /**
     *Initialising GiveAction
     * @param target who is receiving item
     * @param item being given
     **/
    public GiveAction(Actor target, Item item) {
        this.item = item;
        this.target = target;
    }

    /**
     * Method to execute action
     * @param actor who is GIVING the item
     * @param map in which this takes place
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this.item);
        this.target.addItemToInventory(this.item);

        affectFaction(actor);
        Faction faction = FactionStandingManager.allFactions.get(Capabilities.MERCHANT);

        return "Farmer gave "+this.item.toString()+" to "+this.target.toString()+", you standing is as follows: "+faction;
    }

    /**
     * Shows the text option to be displayed on the terminal
     * @param actor The actor performing the action.
     * @return String to be printed
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Give " + this.item.toString() + " to " + this.target.toString();
    }

    @Override
    public void affectFaction(Actor actor) {
        Faction faction = FactionStandingManager.allFactions.get(Capabilities.MERCHANT);
        faction.increaseStanding(1);
    }
}