package gameworld;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;
import items.GoldPile;
import items.ItemHandler;
import player.Human;
import player.Player;

/**
 * Created by Tom on 20/06/2016.
 */
public class GameWorld {
    //----tiled map----
    private TiledMap map;
    //----player----
    private Player player;
    //----items----
    private ItemHandler itemHandler;

    public GameWorld() {
        map = AssetLoader.worldMap;
        itemHandler = new ItemHandler();
        player = new Human(this);
        player.jumpToPosition(AssetLoader.returnMapLocation("treeStartPoint", map));

        itemHandler.dropDefined(new GoldPile(), new Vector2(100,100));
    }

    public void update() {

    }

    public TiledMap getMap() { return map; }

    public Player getPlayer() { return player; }

    public ItemHandler getItemHandler() { return itemHandler; }
}
