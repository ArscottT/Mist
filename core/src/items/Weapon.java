package items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;

/**
 * Created by tom on 07.10.16.
 */

public class Weapon implements Item {
    //----generic item----
    private Vector2 worldPosition;
    private Sprite sprite;
    //----weapon specific----
    public int minDmg = 0, maxDmg = 0, attackRating = 10;
    public char damageType = 'b';
    public String name = "fists";

    public Weapon() {
        worldPosition = new Vector2(0,0);
        sprite = AssetLoader.dragonSprite; //TODO this will be changed to weapon
    }

    @Override
    public void setWorldPosition(Vector2 vec) {
        worldPosition = vec;
    }

    @Override
    public Vector2 getWorldPosition() {
        return worldPosition;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}
