package com.smolus.labyrinth.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.smolus.labyrinth.LabyrinthGame;

/**
 * Created by SMOLUS on 2017-01-15.
 */

public class SplashScreen extends AbstractScreen{

    private Sprite splashImg;

    public SplashScreen(LabyrinthGame game){
        super(game);

        init();
    }

    private void init(){
        spriteBatch = new SpriteBatch();
        splashImg = new Sprite(new Texture("splashscreen.png"));
        splashImg.setSize(3f,3f);
        camera.position.set(1.5f, 1.5f, 0f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();

        splashImg.draw(spriteBatch);

        spriteBatch.end();
    }
}
