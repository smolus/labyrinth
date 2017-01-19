package com.smolus.labyrinth.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.smolus.labyrinth.LabyrinthGame;
import com.smolus.labyrinth.Maze.Generator;
import com.smolus.labyrinth.entities.Joystick;
import com.smolus.labyrinth.entities.Player;

/**
 * Created by SMOLUS on 2017-01-16.
 */

public class GameplayScreen extends Abstract3dScreen{

    private PointLight pointLight;
    private Player player;
    private Joystick joystick;
    private Model wallModel;
    private ModelInstance[] wallInstances = new ModelInstance[121];
    private Generator generator = new Generator(11);

    public GameplayScreen(LabyrinthGame game){
        super(game);
        init();
    }

    private void init(){
        pointLight = new PointLight().set(Color.WHITE, 0, 0, 3f, 4f);
        environment.add(pointLight);
        player = new Player(0,0);
        joystick = new Joystick(stage);

        ModelBuilder modelBuilder = new ModelBuilder();
        wallModel = modelBuilder.createBox(1f,1f,1f,new Material(ColorAttribute.createDiffuse(Color.BLUE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        Model nothing = modelBuilder.createBox(0,0,0, new Material(), VertexAttributes.Usage.Position);
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(generator.board[i + j*11] == 1) {
                    wallInstances[i + j * 11] = new ModelInstance(wallModel, i * 1f, j * 1f, 0);
                }else{
                    wallInstances[i + j * 11] = new ModelInstance(nothing);
                }
            }
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        modelBatch.begin(camera);
        player.show(modelBatch, environment);
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                modelBatch.render(wallInstances[i + j*11], environment);
            }
        }
        modelBatch.end();
        if(Gdx.input.justTouched()){
            joystick.setup(Gdx.input.getX(), Gdx.input.getY());
        }
        if(Gdx.input.isTouched()){
            joystick.update(Gdx.input.getX(),Gdx.input.getY());
            joystick.show();
            player.move(joystick.getDifferenceX(), joystick.getDifferenceY());
            pointLight.position.add(joystick.getDifferenceX() * 0.0005f, joystick.getDifferenceY() * 0.0005f, 0);
            camera.translate(joystick.getDifferenceX() * 0.0005f, joystick.getDifferenceY() * 0.0005f, 0);
        }else{
            joystick.hide();
        }
        stage.act();
        stage.draw();
    }
}
