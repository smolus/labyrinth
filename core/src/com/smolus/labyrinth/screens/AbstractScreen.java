package com.smolus.labyrinth.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.smolus.labyrinth.LabyrinthGame;

/**
 * Created by SMOLUS on 2017-01-15.
 */

public abstract class AbstractScreen implements Screen{

    protected LabyrinthGame game;

    protected Stage stage;
    protected OrthographicCamera camera;
    private Viewport viewport;

    protected SpriteBatch spriteBatch;

    public AbstractScreen(LabyrinthGame game){
        this.game = game;
        createCamera();
        createViewport();
        createBatch();
    }

    private void createBatch() {
        spriteBatch = new SpriteBatch();
    }

    private void createViewport() {
        viewport = new ExtendViewport(3, 3, camera);
        viewport.apply();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void createCamera() {
        camera = new OrthographicCamera();

    }

    private void clearScreen() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void dispose() {
        game.dispose();
        spriteBatch.dispose();
        stage.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
