package game.actor.npc;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Capabilities;
import game.actions.BuyAction;
import game.actor.Ability;
import game.items.Buyable;
import game.items.purchaseeffect.AttributeValueChange;
import game.items.purchaseeffect.MaxAttributeChange;
import game.items.purchaseeffect.SpawnActorChange;
import game.items.weapons.Broadsword;
import game.items.weapons.DragonslayerGreatsword;
import game.items.weapons.Katana;

import java.util.ArrayList;
import java.util.List;


/**
 * Class representing the sorceress Sellen NPC
 * @authors Serena Zhou and Aryan M
 */
public class SorceressSellen extends NonPlayableActor{
    public SorceressSellen(){
        super("Sorceress Sellen",'s', 150);
        this.addCapability(Ability.MERCHANT);
        getBuyables();
    }

    /**
     * Method to create items and their customs, and to add them to the merchant's inventory
     */
    private List<Buyable> getBuyables() {
        List<Buyable> buyableList = new ArrayList<>();
        Broadsword broadsword = new Broadsword(100);
        broadsword.addEffect(new MaxAttributeChange(20, BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE));

        DragonslayerGreatsword greatsword = new DragonslayerGreatsword(1500);
        greatsword.addEffect(new SpawnActorChange(new GoldenBeetle()));

        Katana katana = new Katana(500);
        katana.addEffect(new AttributeValueChange(10, BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE));
        katana.addEffect(new MaxAttributeChange(20, BaseActorAttributes.STAMINA, ActorAttributeOperations.INCREASE));
        SpawnActorChange spawnChange = new SpawnActorChange(new OmenSheep());
        spawnChange.addSpawnTarget(this);
        katana.addEffect(spawnChange);

        buyableList.add(broadsword);
        buyableList.add(greatsword);
        buyableList.add(katana);
        return  buyableList;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actionList = super.allowableActions(otherActor, direction, map);
        for (Buyable buyable: this.getBuyables()) {
            actionList.add(new BuyAction(buyable));
        }

        return actionList;
    }
}
