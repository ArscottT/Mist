package items;

import java.util.ArrayList;

/**
 * Created by Tom on 20/06/2016.
 */
public class Backpack {
    private ArrayList<Item> packList;

    public Backpack() {packList = new ArrayList<Item>();}

    public void putIn(Item item) {
        packList.add(item);
        //item.setIndex(packList.indexOf(item));
    }

    public void removeDefined(int i) {
        packList.remove(i);
    }

    public void removeDefined(Item item) {
        packList.remove(item);
    }

    public ArrayList getList() {
        return packList;
    }
}
