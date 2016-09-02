package assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by Tom on 20/06/2016.
 */
public class AssetLoader {
    public static AssetManager assetManager;
    //----Assets----
    public static TiledMap worldMap;

    public static void create() {
        assetManager = new AssetManager();
        load();
    }

    private static void load() {
        worldMap = new TmxMapLoader().load("maps/levels/Newmap.tmx");
        //assetManager.load("Dragon.png", Sprite.class);
    }

    public static void done() {
    }

    public static void dispose() {
        assetManager.dispose();
        worldMap.dispose();
    }
}
