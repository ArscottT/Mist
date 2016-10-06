package ui_main_menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import screens.MainMenuScreen;

/**
 * Created by Tom on 20/06/2016.
 */
public class UiStageMMenu extends Stage {
    private Stage stage;
    private TextButton startGameButton;
    private TextButtonStyle startGameButtonStyle;
    private BitmapFont font;
    private Table MainMenuTable = new Table();

    public UiStageMMenu(MainMenuScreen mainMenuScreenO) {
        final MainMenuScreen mainMenuScreen = mainMenuScreenO;
        //this.mainMenuScreen = mainMenuScreen; //this is here from when mms was declared outside the method
        stage = new Stage(new ScreenViewport());

        startGameButtonStyle = new TextButtonStyle();
        font = new BitmapFont();
        font.getData().setScale(10, 10);
        startGameButtonStyle.font = font;
        startGameButton = new TextButton("Start Button", startGameButtonStyle);
        startGameButton.setBounds(startGameButton.getX(), startGameButton.getY(), startGameButton.getWidth(), startGameButton.getHeight());

        startGameButton.setTouchable(Touchable.enabled);
        startGameButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button){
                mainMenuScreen.startGame(); //this forced me to declare the variable inside the scope
                return true;
            }});

        MainMenuTable.add(startGameButton).minWidth(2000).center();
        MainMenuTable.setFillParent(true);
        MainMenuTable.debug(); // this is for debugging the table

        stage.addActor(MainMenuTable);
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
