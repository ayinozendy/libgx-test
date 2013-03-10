package com.gamalinda.libgdx.test.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class ShowTiledMapScreen implements Screen {

    OrthographicCamera camera;
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

    @Override
    public void render(float v) {
        clearScreen();
        camera.update();
        renderMap();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 1f, 1f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
    }

    private void renderMap() {
        orthogonalTiledMapRenderer.setView(camera);
        orthogonalTiledMapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        tiledMap = new TmxMapLoader().load("res/maps/testmap.tmx");
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    @Override
    public void hide() {
        tiledMap.dispose();
        orthogonalTiledMapRenderer.dispose();
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
