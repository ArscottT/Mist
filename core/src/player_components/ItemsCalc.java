package player_components;

import java.util.ArrayList;

import gameworld.GameWorld;
import helpers.Calcs;
import items.Backpack;
import items.Item;
import items.ItemHandler;
import player.Player;

/**
 * Created by tom on 12.10.16.
 */

public class ItemsCalc {
    //----comtext----
    private GameWorld world;
    private Player player;
    //----items----
    private ItemHandler itemHandler;
    private Backpack backpack;
    private ArrayList<Item> itemList;

    public ItemsCalc(GameWorld world, Player player) {
        this.world = world;
        this.player = player;
        this.itemHandler = world.getItemHandler();
        this.itemList = itemHandler.getList();
        this.backpack = player.getBackpack();
    }

    public void searchForItems() {
        for (Item item : itemList) {
            if (Calcs.calcPickupDistance(player, item)) {
                pickUp(item);
            }
        }
    }

    public void drop(Item item) {
        itemHandler.dropDefined(item, player.getPosition());
        backpack.removeDefined(item);
    }

    private void pickUp(Item item) {
        backpack.putIn(item);
        itemHandler.removeDefined(item);
    }
}
