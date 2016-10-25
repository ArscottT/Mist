package items;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by tom on 07.10.16.
 */

public class Weapon implements Item {
    //----generic item----
    private Vector2 worldPosition;
    //----weapon specific----
    public int minDmg = 0, maxDmg = 0, attackRating = 10;
    public char damageType = 'b';
    public String name = "fists";

    public Weapon() {
        worldPosition = new Vector2(0,0);
    }

    public Vector2 getWorldPosition() {
        return worldPosition;
    }
}
