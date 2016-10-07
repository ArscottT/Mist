package player_components;

import helpers.Dmg;

/**
 * Created by tom on 07.10.16.
 */

public class DefendCalc {

    public DefendCalc() {

    }

    public int defend(Dmg dmg, int baseAttackRating) {
        if(calcHit(baseAttackRating, dmg)) {
            return dmg.damage;
        }
        else {
            return 0;
        }
    }

    private boolean calcHit(int baseAttackRating, Dmg dmg) {
        if(baseAttackRating < dmg.attackRating) { //needs to be percentage based
            return true;
        }
        else {
            return false;
        }
    }
}
