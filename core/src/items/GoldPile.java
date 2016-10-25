package items;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tom on 20/06/2016.
 */
public class GoldPile implements Item {
    //----generic item----
    private Vector2 worldPosition;
    //----gold specific----

    public GoldPile() {
        worldPosition = new Vector2(0,0);
    }

    public Vector2 getWorldPosition() {
        return worldPosition;
    }
}
