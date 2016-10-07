package player_components;

import com.badlogic.gdx.math.MathUtils;

import helpers.Dmg;
import items.Weapon;

/**
 * Created by tom on 07.10.16.
 */

public class AttackCalc {
    private Dmg dmg;

    public AttackCalc() {
        dmg = new Dmg();
    }

    public Dmg attack(Weapon weapon, int baseDmg, int baseAttackRating) {
        dmg.damage = calcDamage(weapon, baseDmg);
        dmg.damageType = calcDamageType(weapon);
        dmg.attackRating = calcAttackRating(weapon, baseAttackRating);
        return dmg;
    }

    private int calcDamage(Weapon weapon, int baseDmg) {
        return MathUtils.random(weapon.minDmg, weapon.maxDmg) + baseDmg;
    }

    private char calcDamageType(Weapon weapon) {
        return weapon.damageType;
    }

    private int calcAttackRating(Weapon weapon, int baseAttackRating) {
        return weapon.attackRating + baseAttackRating;
    }
}
