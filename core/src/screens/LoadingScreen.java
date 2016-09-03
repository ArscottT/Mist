package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import assets.AssetLoader;

/**
 * Created by Tom on 20/06/2016.
 */
public class LoadingScreen implements Screen {
    private BitmapFont font;
    private SpriteBatch batch;
    private Game game;

    public LoadingScreen(Game game) {
        Gdx.app.log("LoadingScreen", "Attached");
        this.game = game;
        AssetLoader.create();
        batch = new SpriteBatch();
        font = new BitmapFont();
        //showMainMenu();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Loading...", 100, 100);
        batch.end();
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

    private void showMainMenu() {
        AssetLoader.loadMainMenu();
        //if (AssetLoader.assetManager.update()) {
            AssetLoader.done();
            game.setScreen(new MainMenuScreen(game));
        //}
    }
}
