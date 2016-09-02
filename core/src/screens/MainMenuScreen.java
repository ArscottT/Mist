package screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import ui_main_menu.UiStageMMenu;

/**
 * Created by Tom on 20/06/2016.
 */
public class MainMenuScreen implements Screen {
    private Game game;
    private float deltaTime;
    private UiStageMMenu MMStage;

    public MainMenuScreen(Game game) {
        this.game = game;
        MMStage = new UiStageMMenu(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        deltaTime  = Gdx.graphics.getDeltaTime();
        MMStage.render(deltaTime);
    }

    public void startGame() {
        game.setScreen(new GameScreen(game, this));
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
