package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        font.draw(batch, "Loading...", 100, 100);
        batch.end();
        if (AssetLoader.assetManager.update()) {
            AssetLoader.done();
            game.setScreen(new MainMenuScreen(game));
        }
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
