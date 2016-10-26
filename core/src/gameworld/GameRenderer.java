package gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;

import assets.AssetLoader;
import items.Item;

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
    //----items----
    private ArrayList<Item> itemList;
    //----camera control----
    int tileSize = 0, mapWidth = 0, mapHeight = 0;
    //----other----
    private SpriteBatch batch;
    private float elapsedTime = 0;

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

        //----items----
        this.itemList = world.getItemHandler().getList();

        //----camera control----
        this.tileSize = AssetLoader.tileSize;
        this.mapWidth = AssetLoader.mapWidth;
        this.mapHeight = AssetLoader.mapHeight;

        //----sprites----
        batch = new SpriteBatch();
    }

    public void render() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Gdx.app.log("GameRenderer", "render");

        //----tiled map----
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        //----sprite batch----
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

            for (Item item : itemList) {
                batch.draw(item.getSprite(), item.getWorldPosition().x - (item.getSprite().getWidth()/2),
                    item.getWorldPosition().y - (item.getSprite().getHeight()/2));
            }

            if (world.getPlayer().getMoving() == 'n') {
                batch.draw(world.getPlayer().getSprite(),
                    world.getPlayer().getPosition().x - world.getPlayer().getPlayerRectC().x,
                    world.getPlayer().getPosition().y - world.getPlayer().getPlayerRectC().y);
            }
            else {
                batch.draw(world.getPlayer().getAnimation().getKeyFrame(elapsedTime, true),
                    world.getPlayer().getPosition().x - world.getPlayer().getPlayerRectC().x,
                    world.getPlayer().getPosition().y - world.getPlayer().getPlayerRectC().y);
            }

        batch.end();

        //----camera----
        updateCamera();
    }

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
    }
}
