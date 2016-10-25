package assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tom on 20/06/2016.
 */
public class AssetLoader {
    //----assets----
    public static AssetManager assetManager;
    //----player
    public static Animation playerWalkUpAnimation, playerWalkRightAnimation, playerWalkDownAnimation, playerWalkLeftAnimation;
    public static Sprite playerLookUp, playerLookRight, playerLookDown, playerLookLeft;
    public static Rectangle playerRect;
    public static Vector2 playerRecC;
    //----maps
    public static TiledMap worldMap;
    public static int tileSize = 0, mapWidth = 0, mapHeight = 0;
    //----enemies
    public static Sprite dragonSprite;
    //----items
    public static Sprite goldPileSprite;


    public static void create() {
        assetManager = new AssetManager();
        //other things that need to initialised should be put here, but ones that are only needed over all
    }

    public static void done() {
    }

    public static void dispose() {
        assetManager.dispose();
        worldMap.dispose();
    }

    public static int loadMainMenu(){

        return 1;
    }

    public static int loadGameWorld() {
        loadMapVars();
        //assetManager.load("Dragon.png", Sprite.class);
        loadCharacterAssets(4); //TODO this will eventually be move out into the main menu
        loadItems();
        loadEnemies();

        return 1;
    }

    public static Vector2 returnMapLocation(String location, TiledMap map) {
        MapLayer locationLayer;
        MapObjects locationObjects;
        MapObject locationOb;
        float locX, locY;

        //get layer/ objects
        locationLayer = map.getLayers().get("locationLayer");
        locationObjects = locationLayer.getObjects();
        //get location coordinates
        locationOb = locationObjects.get(location);
        locX = (Float) locationOb.getProperties().get("x");
        locY = (Float) locationOb.getProperties().get("y");

        return new Vector2(locX, locY);
    }

    public static MapObjects returnCollisionObjects(TiledMap map) {
        MapLayer collisionLayer;
        MapObjects collisionObjects;

        //get layer/objects
        collisionLayer = map.getLayers().get("collisionLayer");
        collisionObjects = collisionLayer.getObjects();
        return collisionObjects;
    }

    private static void loadMapVars() {
        TiledMapTileLayer groundLayer;

        worldMap = new TmxMapLoader().load("maps/levels/Newmap.tmx");
        groundLayer = (TiledMapTileLayer) worldMap.getLayers().get("Ground Layer");
        tileSize = (int) groundLayer.getTileWidth();
        mapWidth = groundLayer.getWidth() * tileSize;
        mapHeight = groundLayer.getHeight() * tileSize;
    }

    private static void loadItems() {
        Texture goldPileTextureSheet;

        //gold coin load
        goldPileTextureSheet = new Texture(Gdx.files.internal("gold.png"));
        goldPileSprite = new Sprite(goldPileTextureSheet,0,64,32,32);
    }

    private static void loadEnemies() {
        Texture dragonTexture;

        //dragon load
        dragonTexture = new Texture(Gdx.files.internal("dragon.PNG"));
        dragonSprite = new Sprite(dragonTexture);
    }

    //----private functions
    private static void loadCharacterAssets(int c) {
        //----animation parameters
        final int FRAME_COLS = 12;
        final int FRAME_ROWS = 8;
        final int ANIMATION_FRAMES = 2;
        //----character variables
        Texture characterTexture;
        TextureRegion[] playerWalkUp, playerWalkDown, playerWalkLeft, playerWalkRight;
        TextureRegion[][] tmp;
        int offsetRow, offsetColumn;

        //----load generic textures etc.
        characterTexture = new Texture(Gdx.files.internal("characters.png"));
        tmp = TextureRegion.split(characterTexture, characterTexture.getWidth()/FRAME_COLS, characterTexture.getHeight()/FRAME_ROWS);              // #10
        playerWalkUp = new TextureRegion[ANIMATION_FRAMES];
        playerWalkRight = new TextureRegion[ANIMATION_FRAMES];
        playerWalkDown = new TextureRegion[ANIMATION_FRAMES];
        playerWalkLeft = new TextureRegion[ANIMATION_FRAMES];

        //----load offset for character selection
        if (c <= 3) { offsetRow = 0; }
        else { offsetRow = 4; }

        if (c == 0 || c == 4) { offsetColumn = 0; }
        else if  (c == 1 || c == 5) { offsetColumn = 3; }
        else if  (c == 2 || c == 6) { offsetColumn = 6; }
        else {offsetColumn = 9; }

        //----load walking animation from region
        playerWalkUp[0] = tmp[3 + offsetRow][offsetColumn];
        playerWalkUp[1] = tmp[3 + offsetRow][2 + offsetColumn];
        playerWalkRight[0] = tmp[2 + offsetRow][offsetColumn];
        playerWalkRight[1] = tmp[2 + offsetRow][2 + offsetColumn];
        playerWalkDown[0] = tmp[offsetRow][offsetColumn];
        playerWalkDown[1] = tmp[offsetRow][2 + offsetColumn];
        playerWalkLeft[0] = tmp[1 + offsetRow][offsetColumn];
        playerWalkLeft[1] = tmp[1 + offsetRow][2 + offsetColumn];
        //----load animation
        playerWalkUpAnimation = new Animation(0.3f, playerWalkUp);
        playerWalkRightAnimation = new Animation(0.3f, playerWalkRight);
        playerWalkDownAnimation = new Animation(0.3f, playerWalkDown);
        playerWalkLeftAnimation = new Animation(0.3f, playerWalkLeft);
        //----load standing sprite from region
        playerLookUp = new Sprite(tmp[3 + offsetRow][1 + offsetColumn]);
        playerLookRight = new Sprite(tmp[2 + offsetRow][1 + offsetColumn]);
        playerLookDown = new Sprite(tmp[offsetRow][1 + offsetColumn]);
        playerLookLeft = new Sprite(tmp[1 + offsetRow][1 + offsetColumn]);
        //----calc character rect
        playerRecC = new Vector2(); // I no longer think I need this
        playerRect = new Rectangle(0, 0, characterTexture.getWidth()/FRAME_COLS, characterTexture.getHeight()/FRAME_ROWS);
        playerRecC = playerRect.getCenter(playerRecC);
    }
}
