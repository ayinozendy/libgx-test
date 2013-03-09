package com.gamalinda.libgdx.test;

import com.badlogic.gdx.Game;
import com.gamalinda.libgdx.test.screen.ShowImageScreen;

public class MainApp extends Game {

    @Override
    public void create() {
        this.setScreen(new ShowImageScreen());
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
