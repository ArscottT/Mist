package com.torqueskrew.dom;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import assets.AssetLoader;
import screens.LoadingScreen;

public class DungeonsOfMist extends Game {
	private Game game;

	@Override
	public void create () {
		Gdx.app.log("MistBAGame", "created");
        game = this;
        setScreen(new LoadingScreen(game));
	}

	@Override
	public void render () {
        super.render();
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
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
