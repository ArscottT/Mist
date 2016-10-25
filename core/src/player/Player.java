package player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import helpers.Dmg;
import items.Backpack;

/**
 * Created by Tom on 20/06/2016.
 */
public interface Player {
    void movement(char d);
    void jumpToPosition(Vector2 vec);
    Dmg attack();
    void defend(Dmg dmg);
    void skillAttack();
    void skillSelf();
    void skillOther();
    void pickUp();
    Vector2 getPosition();
    char getMoving();
    Rectangle getPlayerRect();
    Vector2 getPlayerRectC();
    Animation getAnimation();
    Sprite getSprite ();
    Backpack getBackpack();
}
