package helpers;

import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;
import enemies.Enemy;
import items.Item;
import player.Player;

/**
 * Created by Tom on 20/06/2016.
 */
public class Calcs {

    public static boolean calcPickupDistance(Player player, Item item) {
        if (calcDistance(player, item) <= 2) {
            return true;
        }
        else return false;
    }

    private static float calcDistance (Player player, Item item) {
        Vector2 vecP, vecO, vecPT, vecOT;
        float a, b, c;

        vecP = player.getPosition();
        vecO = item.getWorldPosition();

        vecPT = new Vector2(0,0);
        vecOT = new Vector2(0,0);

        //TODO i this a correct calculation for number of tiles

        vecPT.x = vecP.x / AssetLoader.tileSize;
        vecPT.y = vecP.y / AssetLoader.tileSize;
        vecOT.x = vecO.x / AssetLoader.tileSize;
        vecOT.y = vecO.y / AssetLoader.tileSize;

        a = Math.abs(vecPT.x - vecOT.x);
        b = Math.abs(vecPT.y - vecOT.y);

        c = (a*a) * (b * b);
        return c;
    }
    /*
    private static float calcDistance (Player playerClass, Enemy enemy) {
        Vector2 vecP, vecO, vecPT, vecOT;
        float a, b, c;

        vecP = playerClass.getPosition();
        vecO = enemy.getPosition();

        vecPT = new Vector2(0,0);
        vecOT = new Vector2(0,0);

        vecPT.x = vecP.x / AssetLoader.tileSize;
        vecPT.y = vecP.y / AssetLoader.tileSize;
        vecOT.x = vecO.x / AssetLoader.tileSize;
        vecOT.y = vecO.y / AssetLoader.tileSize;

        a = Math.abs(vecPT.x - vecOT.x);
        b = Math.abs(vecPT.y - vecOT.y);

        c = (a*a) * (b * b);
        return c;
    }*/
}
