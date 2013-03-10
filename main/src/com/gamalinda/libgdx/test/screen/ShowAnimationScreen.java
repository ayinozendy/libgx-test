package com.gamalinda.libgdx.test.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ShowAnimationScreen implements Screen {

    private static final int FRAME_COLS = 6;
    private static final int FRAME_ROWS = 5;

    private OrthographicCamera camera;
    private Texture spriteSheet;
    private TextureRegion[] textureRegion;
    private SpriteBatch spriteBatch;
    private Animation animation;

    private float stateTime;

    @Override
    public void render(float v) {
        clearScreen();
        camera.update();
        renderSpriteBatch();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    private void renderSpriteBatch() {
        stateTime += Gdx.graphics.getDeltaTime();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), 0, 0);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        textureRegion = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        spriteSheet = new Texture(Gdx.files.internal("res/images/animation_sheet.png"));
        spriteBatch = new SpriteBatch();
        loadRunAnimation();
    }

    private void loadRunAnimation() {
        TextureRegion[][] tmp = TextureRegion.split(spriteSheet, spriteSheet.getWidth() /
                FRAME_COLS, spriteSheet.getHeight() / FRAME_ROWS);
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                textureRegion[index++] = tmp[i][j];
            }
        }
        animation = new Animation(0.025f, textureRegion);
    }

    @Override
    public void hide() {
        spriteSheet.dispose();
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
