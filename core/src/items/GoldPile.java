package items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;

/**
 * Created by Tom on 20/06/2016.
 */
public class GoldPile implements Item {
    //----generic item----
    private Vector2 worldPosition;
    private Sprite sprite;
    //----gold specific----

    public GoldPile() {
        worldPosition = new Vector2(0,0);
        sprite = AssetLoader.goldPileSprite;
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
