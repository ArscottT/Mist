package items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tom on 20/06/2016.
 */
public interface Item {
    void setWorldPosition(Vector2 vec);
    Vector2 getWorldPosition();
    Sprite getSprite();
}
