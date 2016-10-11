package gameworld;

import com.badlogic.gdx.maps.tiled.TiledMap;

import assets.AssetLoader;
import player.Human;
import player.Player;

/**
 * Created by Tom on 20/06/2016.
 */
public class GameWorld {
    private TiledMap map;
    private Player player;

    public GameWorld() {
        map = AssetLoader.worldMap;
        player = new Human(this);
    }

    public void update() {

    }

    public TiledMap getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }
}
