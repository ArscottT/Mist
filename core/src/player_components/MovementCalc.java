package player_components;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import assets.AssetLoader;
import gameworld.GameWorld;

/**
 * Created by tom on 07.10.16.
 */

public class MovementCalc {
    GameWorld world;

    public MovementCalc(GameWorld world) {
        this.world = world;
    }

    public void move(Vector2 position, char d, int velocity, Rectangle playerRect) {
        switch (d) {//TODO not sure if calling collision every time is good for speed
            case 'r':
                setPlayerRect(playerRect, position.x+velocity,position.y);
                if (checkCollision(playerRect)){
                    //Collision happened don't move
                    setPlayerRect(playerRect, position.x,position.y);
                    break;
                }
                else {
                    position.x += velocity;
                    setPlayerRect(playerRect, position.x,position.y);
                }
                break;
            case 'l':
                setPlayerRect(playerRect, position.x-velocity,position.y);
                if (checkCollision(playerRect)){
                    //Collision happened don't move
                    setPlayerRect(playerRect, position.x,position.y);
                    break;
                }
                else {
                    position.x -= velocity;
                    setPlayerRect(playerRect, position.x,position.y);
                }
                break;
            case 'u':
                setPlayerRect(playerRect, position.x,position.y+velocity);
                if (checkCollision(playerRect)){
                    //Collision happened don't move
                    setPlayerRect(playerRect, position.x,position.y);
                    break;
                }
                else {
                    position.y += velocity;
                    setPlayerRect(playerRect, position.x,position.y);
                }
                break;
            case 'd':
                setPlayerRect(playerRect, position.x,position.y-velocity);
                if (checkCollision(playerRect)){
                    //Collision happened don't move
                    setPlayerRect(playerRect, position.x,position.y);
                    break;
                }
                else {
                    position.y -= velocity;
                    setPlayerRect(playerRect, position.x,position.y);
                }
                break;
            default:
                break;
        }
    }

    private boolean checkCollision(Rectangle playerRect) {//TODO something happens to the collision detection when you change the velocity
        for (RectangleMapObject rectangleObject : AssetLoader.returnCollisionObjects(world.getMap()).getByType(RectangleMapObject.class)) {//TODO .class?
            Rectangle rectangle = rectangleObject.getRectangle();//TODO find better collision method. Calling for all rectangles is not good
            if (Intersector.overlaps(rectangle, playerRect)) {
                // collision happened
                //Gdx.app.log("PlayerClass", "Collision Detected");
                return true;
            }
        }
        return false;
    }

    private void setPlayerRect(Rectangle playerRect, float xP, float yP) {
        playerRect.setCenter(xP,yP);
    }
}
