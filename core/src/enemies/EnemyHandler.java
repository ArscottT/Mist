package enemies;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Tom on 20/06/2016.
 */
public class EnemyHandler {
    private ArrayList<Enemy> enemyList;

    public EnemyHandler() {
        enemyList = new ArrayList<Enemy>();
    }

    public void spawnDefined(Enemy enemy, Vector2 vec) {
        enemy.setWorldPosition(vec);
        enemyList.add(enemy);
    }

    public void removeDefined(Enemy enemy) {
        enemyList.remove(enemy);
    }

    public ArrayList getList() {
        return enemyList;
    }
}
