package gameworld;

import com.badlogic.gdx.maps.tiled.TiledMap;

import assets.AssetLoader;
import player.Player;

/**
 * Created by Tom on 20/06/2016.
 */
public class GameWorld {
    private TiledMap map;
    //Player player;

    public GameWorld() {
        map = AssetLoader.worldMap;
    }

    public void upDate() {

    }

    public TiledMap getMap() {
        return map;
    }
}
