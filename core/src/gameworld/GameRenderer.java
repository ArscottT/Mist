package gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Tom on 20/06/2016.
 */
public class GameRenderer {
    //----world----
    private GameWorld world;
    //----camera----
    private OrthographicCamera camera;
    private float cameraLeft;
    private float cameraRight;
    private float cameraBottom;
    private float cameraTop;
    private float cameraHalfWidth;
    private float cameraHalfHeight;
    //----tiled map----
    private TiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer groundLayer;
    //----other----
    private SpriteBatch batch;

    public GameRenderer(GameWorld world) {
        this.world = world;

        //----camera----
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1024, 512);
        cameraHalfWidth = camera.viewportWidth/2;  // The camera dimensions, halved
        cameraHalfHeight = camera.viewportHeight/2;

        //----map renderer----
        tiledMapRenderer = new OrthogonalTiledMapRenderer(world.getMap());
        tiledMapRenderer.setView(camera);
    }

    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Gdx.app.log("GameRenderer", "render");

        //----tiled map----
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        /*
        //----sprite batch----
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        */
        //----camera----
        //updateCamera();
    }
    /*
    private void updateCamera() {
        camera.position.x = world.getPlayer().getPosition().x;
        camera.position.y = world.getPlayer().getPosition().y;

        cameraLeft = camera.position.x - cameraHalfWidth;
        cameraRight = camera.position.x + cameraHalfWidth;
        cameraBottom = camera.position.y - cameraHalfHeight;
        cameraTop = camera.position.y + cameraHalfHeight;

        // Horizontal axis
        if(mapWidth < camera.viewportWidth)
        {
            camera.position.x = mapWidth / 2;
        }
        else if(cameraLeft <= 0) //Assuming left boarder of map is position 0
        {
            camera.position.x = cameraHalfWidth;
        }
        else if(cameraRight >= mapWidth) //mapWidth = right boarder of map
        {
            camera.position.x = mapWidth - cameraHalfWidth;
        }

        // Vertical axis
        if(mapHeight < camera.viewportHeight)
        {
            camera.position.y = mapHeight / 2;
        }
        else if(cameraBottom <= 0) //Assuming bottom boarder of map is position 0
        {
            camera.position.y = cameraHalfHeight;
        }
        else if(cameraTop >= mapHeight) //mapHeight = top boarder of map
        {
            camera.position.y = mapHeight - cameraHalfHeight;
        }
        camera.update();
    }*/
}
