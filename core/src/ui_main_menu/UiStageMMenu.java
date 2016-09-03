package ui_main_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import screens.MainMenuScreen;

/**
 * Created by Tom on 20/06/2016.
 */
public class UiStageMMenu extends Stage {
    private MainMenuScreen mainMenuScreen;
    private Stage stage;
    private Actor startGameButton;

    public UiStageMMenu(MainMenuScreen mainMenuScreen) {
        this.mainMenuScreen = mainMenuScreen;
        stage = new Stage(new ScreenViewport());
        startGameButton = new Actor();

        stage.addActor(startGameButton);
        startGameButton.setTouchable(Touchable.enabled);
        startGameButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button){
                //MainMenuScreen.startGame();
                return true;
            }});

        Gdx.input.setInputProcessor(stage);
    }

    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void render (float delta) {
        stage.act(delta);
        stage.draw();
    }
}
