package com.torqueskrew.dom;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class DungeonsOfMist extends Game {
	
	@Override
	public void create () {
		Gdx.app.log("MistBAGame", "created");
        //setScreen(new GameScreen());
	}

	@Override
	public void render () {
        super.render();
	}

    @Override
    public void dispose() {
        super.dispose();
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
}
