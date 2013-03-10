package com.gamalinda.libgdx.test;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gamalinda.libgdx.test.screen.ShowAnimationScreen;
import com.gamalinda.libgdx.test.screen.ShowImageScreen;
import com.gamalinda.libgdx.test.screen.ShowTiledMapScreen;

public class MainApp extends Game {
    private final static int IMAGE_SCREEN = 0;
    private final static int ANIMATION_SCREEN = IMAGE_SCREEN + 1;
    private final static int TILEMAP_SCREEN = ANIMATION_SCREEN + 1;
    private static int CURRENT_SCREEN = IMAGE_SCREEN;

    ShowImageScreen imageScreen = new ShowImageScreen();
    ShowAnimationScreen animationScreen = new ShowAnimationScreen();
    ShowTiledMapScreen tiledMapScreen = new ShowTiledMapScreen();

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
        if (Gdx.input.justTouched()) {
            nextScreen();
        }
    }

    private void nextScreen() {
        CURRENT_SCREEN++;
        switch (CURRENT_SCREEN) {
            case IMAGE_SCREEN:
                this.setScreen(imageScreen);
                break;
            case ANIMATION_SCREEN:
                this.setScreen(animationScreen);
                break;
            case TILEMAP_SCREEN:
                this.setScreen(tiledMapScreen);
                break;
            default:
                this.setScreen(imageScreen);
                CURRENT_SCREEN = IMAGE_SCREEN;
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
