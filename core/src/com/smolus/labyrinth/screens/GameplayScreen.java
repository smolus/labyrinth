package com.smolus.labyrinth.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.smolus.labyrinth.LabyrinthGame;
import com.smolus.labyrinth.entities.Player;

/**
 * Created by SMOLUS on 2017-01-16.
 */

public class GameplayScreen extends Abstract3dScreen{

    PointLight pointLight;
    Player player;

    public GameplayScreen(LabyrinthGame game){
        super(game);
        init();
    }

    private void init(){
        pointLight = new PointLight().set(Color.WHITE, 0, 0, 3f, 4f);
        environment.add(pointLight);
        Texture texture = new Texture(Gdx.files.internal("badlogic.jpg"));
        Image image = new Image(texture);
        image.setPosition(0,0);
        stage.addActor(image);
        player = new Player(0,0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        modelBatch.begin(camera);
        player.show(modelBatch, environment);
        modelBatch.end();
        stage.act();
        stage.draw();
    }
}
