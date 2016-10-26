package gameworld;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;
import enemies.Dragon;
import enemies.EnemyHandler;
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
    //---- enemies----
    private EnemyHandler enemyHandler;

    public GameWorld() {
        map = AssetLoader.worldMap;
        itemHandler = new ItemHandler();
        enemyHandler = new EnemyHandler();
        player = new Human(this);
        player.jumpToPosition(AssetLoader.returnMapLocation("treeStartPoint", map));

        itemHandler.dropDefined(new GoldPile(), new Vector2(100,100));
        enemyHandler.spawnDefined(new Dragon(), new Vector2(200,200));
    }

    public void update() {

    }

    public TiledMap getMap() { return map; }

    public Player getPlayer() { return player; }

    public ItemHandler getItemHandler() { return itemHandler; }

    public EnemyHandler getEnemyHandler() { return enemyHandler; }
}
