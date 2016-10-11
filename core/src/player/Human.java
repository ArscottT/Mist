package player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;
import gameworld.GameWorld;
import helpers.Dmg;
import items.Weapon;
import player_components.AttackCalc;
import player_components.DefendCalc;
import player_components.MovementCalc;

/**
 * Created by Tom on 20/06/2016.
 */
public class Human implements Player {
    //----Movement----
    private Vector2 position;
    private int velocity = 1;
    private Rectangle playerRect;
    private char moving = 'n', movingPrev ='n';
    //----components----
    private AttackCalc attackCalc;
    private DefendCalc defendCalc;
    private MovementCalc movementCalc;
    //----items----
    private Weapon weapon;
    //----stats----
    private int baseDmg = 10, baseAttackRating = 10; //random number at the moment
    private int health = 200;

    public Human(GameWorld world) {
        //----movement----
        position = new Vector2(0,0);
        playerRect = AssetLoader.playerRect;
        //----components----
        attackCalc = new AttackCalc();
        defendCalc = new DefendCalc();
        movementCalc = new MovementCalc(world);
        //----items----
        weapon = new Weapon();
    }

    @Override
    public void movement(char d) {
        if (d == 'n') {
            moving = d;
        }
        else {
            movementCalc.move(position, d, velocity, playerRect);
        }
    }

    @Override
    public Dmg attack() {
        return attackCalc.attack(weapon, baseDmg, baseAttackRating);
    }

    @Override
    public void defend(Dmg dmg) {
        health -= defendCalc.defend(dmg, baseAttackRating);
    }

    @Override
    public void skillAttack() {

    }

    @Override
    public void skillSelf() {

    }

    @Override
    public void skillOther() {

    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public char getMoving() {return moving; }

    @Override
    public  Rectangle getPlayerRect() {
        return playerRect;
    }

    @Override
    public  Vector2 getPlayerRectC() {
        return playerRect.getCenter(new Vector2()); //TODO does this cause memory usage? New one every time?
    }

    public Animation getAnimation() { //TODO should this link to a player variable not AssetLoader
        if (moving == 'u') {
            movingPrev = 'u';
            return AssetLoader.playerWalkUpAnimation;
        }
        else if (moving == 'r') {
            movingPrev = 'r';
            return AssetLoader.playerWalkRightAnimation;
        }
        else if (moving == 'd') {
            movingPrev = 'd';
            return AssetLoader.playerWalkDownAnimation;
        }
        else if (moving == 'l') {
            movingPrev = 'l';
            return AssetLoader.playerWalkLeftAnimation;
        }
        return AssetLoader.playerWalkUpAnimation;
    }

    public Sprite getSprite () {
        if (movingPrev == 'u') {
            return AssetLoader.playerLookUp;
        }
        else if (movingPrev == 'r') {
            return AssetLoader.playerLookRight;
        }
        else if (movingPrev == 'd') {
            return AssetLoader.playerLookDown;
        }
        else if (movingPrev == 'l') {
            return AssetLoader.playerLookLeft;
        }
        return AssetLoader.playerLookUp;
    }
}
