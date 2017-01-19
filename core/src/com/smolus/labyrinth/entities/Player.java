package com.smolus.labyrinth.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

/**
 * Created by SMOLUS on 2017-01-17.
 */

public class Player {

    private Model model;
    private ModelInstance modelInstance;
    private float x;
    private float y;

    public Player(float x, float y){
        this.x = x;
        this.y = y;
        initModel();
    }

    private void initModel() {
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createSphere(1f,1f,1f, 20, 20, new Material(ColorAttribute.createDiffuse(Color.GREEN)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(model);
        modelInstance.transform.setTranslation(x, y, 0);
    }


    public void show(ModelBatch m, Environment e){
        m.render(modelInstance, e);
    }

    public void move(int x, int y){
        this.x += x * 0.0005f;
        this.y += y * 0.0005f;
        modelInstance.transform.setTranslation(this.x, this.y, 0);
    }


}
