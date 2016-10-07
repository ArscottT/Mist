package player;

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
        movementCalc.move(position, d, velocity, playerRect);
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
    public  void skillOther() {

    }
}
