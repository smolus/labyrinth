package com.smolus.labyrinth.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.smolus.labyrinth.LabyrinthGame;
import com.smolus.labyrinth.entities.Joystick;
import com.smolus.labyrinth.entities.Player;

/**
 * Created by SMOLUS on 2017-01-16.
 */

public class GameplayScreen extends Abstract3dScreen{

    private PointLight pointLight;
    private Player player;
    private Joystick joystick;

    public GameplayScreen(LabyrinthGame game){
        super(game);
        init();
    }

    private void init(){
        pointLight = new PointLight().set(Color.WHITE, 0, 0, 3f, 4f);
        environment.add(pointLight);
        player = new Player(0,0);
        joystick = new Joystick(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        modelBatch.begin(camera);
        player.show(modelBatch, environment);
        modelBatch.end();
        if(Gdx.input.justTouched()){
            joystick.setup(Gdx.input.getX(), Gdx.input.getY());
        }
        if(Gdx.input.isTouched()){
            joystick.update(Gdx.input.getX(),Gdx.input.getY());
            joystick.show();
            player.move(joystick.getDifferenceX(), joystick.getDifferenceY());
        }else{
            joystick.hide();
        }
        stage.act();
        stage.draw();
    }
}
