package items;

import java.util.ArrayList;

/**
 * Created by Tom on 20/06/2016.
 */
public class ItemHandler {
    private ArrayList<Item> itemList;

    public ItemHandler() { itemList = new ArrayList<Item>();}

    public void dropDefined (Item item){ //TODO should this take in a world position
        itemList.add(item);
        //item.setIndex(itemList.indexOf(item));
    }

    public void removeDefined(int i) {
        itemList.remove(i);
    }

    public void removeDefined(Item item) {
        itemList.remove(item);
    }

    public ArrayList getList() {
        return itemList;
    }
}
