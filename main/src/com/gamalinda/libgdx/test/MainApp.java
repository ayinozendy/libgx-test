package com.gamalinda.libgdx.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gamalinda.libgdx.test.screen.ShowAnimationScreen;
import com.gamalinda.libgdx.test.screen.ShowImageScreen;

public class MainApp extends Game {

    ShowImageScreen imageScreen = new ShowImageScreen();
    ShowAnimationScreen animationScreen = new ShowAnimationScreen();

    @Override
    public void create() {
        this.setScreen(imageScreen);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isTouched()) {
            this.setScreen(animationScreen);
        }
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
