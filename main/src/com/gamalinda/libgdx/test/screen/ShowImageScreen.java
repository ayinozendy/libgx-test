package com.gamalinda.libgdx.test.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ShowImageScreen implements Screen {

    OrthographicCamera camera;
    Texture openSourceLogo;
    SpriteBatch spriteBatch;

    @Override
    public void render(float v) {
        camera.update();
        renderSpriteBatch();
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    private void renderSpriteBatch() {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(openSourceLogo, 0, 0);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        openSourceLogo = new Texture(Gdx.files.internal("res/images/opensource-logo.png"));
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void hide() {
        openSourceLogo.dispose();
        spriteBatch.dispose();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
