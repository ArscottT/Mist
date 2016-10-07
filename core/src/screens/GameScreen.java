package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import assets.AssetLoader;
import gameworld.GameRenderer;
import gameworld.GameWorld;
import ui_game_screen.UiStageGame;

/**
 * Created by Tom on 20/06/2016.
 */
public class GameScreen implements Screen {
    private Game game;
    private Screen parent;
    private GameWorld world;
    private GameRenderer renderer;
    private Stage UIstage;

    public GameScreen(Game game, Screen parent) {
        this.game = game;
        this.parent = parent;
        //this function may have to be moved to a loadGameScreen screen
        AssetLoader.loadGameWorld();
        world = new GameWorld();
        renderer = new GameRenderer(world);
        UIstage = new UiStageGame();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        renderer.render();
        world.upDate();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
