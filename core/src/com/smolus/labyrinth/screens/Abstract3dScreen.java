package com.smolus.labyrinth.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.smolus.labyrinth.LabyrinthGame;

/**
 * Created by SMOLUS on 2017-01-16.
 */

public abstract class Abstract3dScreen implements Screen{

    protected LabyrinthGame game;
    private Viewport viewport;
    protected PerspectiveCamera camera;
    protected ModelBatch modelBatch;
    protected Environment environment;
    protected Stage stage;

    public Abstract3dScreen(LabyrinthGame game){
        this.game = game;
        createCamera();
        createViewport();
        init();
    }

    private void init(){
        modelBatch = new ModelBatch();
        environment = new Environment();
        stage = new Stage();
    }

    private void createViewport() {
        viewport = new ExtendViewport(3f,3f,camera);
        viewport.apply();
    }

    private void createCamera() {
        camera = new PerspectiveCamera();
        camera.near = 0.1f;
        camera.far = 11f;
        camera.position.set(0,0,4f);
        camera.lookAt(0,0,0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.dispose();
        stage.dispose();
        modelBatch.dispose();
    }
}
