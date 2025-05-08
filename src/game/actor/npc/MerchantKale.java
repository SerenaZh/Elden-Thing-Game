package game.actor.npc;

import game.items.Buyable;

import java.util.List;

public class MerchantKale extends NonPlayableActor {
    private List<Buyable> waresInventory;

    public MerchantKale(){
        super("Merchant Kale", 'k', 200);
    }

    public void addWareToInventory(Buyable buyable) {
//        waresInventory.add()
    }
}
