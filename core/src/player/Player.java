package player;

import helpers.Dmg;

/**
 * Created by Tom on 20/06/2016.
 */
public interface Player {
    void movement(char d);
    Dmg attack();
    void defend(Dmg dmg);
    void skillAttack();
    void skillSelf();
    void skillOther();
}
