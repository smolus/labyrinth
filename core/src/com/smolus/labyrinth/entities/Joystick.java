package com.smolus.labyrinth.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by SMOLUS on 2017-01-18.
 */

public class Joystick {

    private Texture texture;
    private Image big;
    private  Image small;

    private int bigX, bigY, smallX, smallY;

    public Joystick(Stage stage){
        texture = new Texture(Gdx.files.internal("circle.png"));
        big = new Image(texture);
        small = new Image(texture);
        big.setSize(150,150);
        small.setSize(50,50);
        big.setVisible(false);
        small.setVisible(false);
        stage.addActor(big);
        stage.addActor(small);
    }

    public void setup(int x, int y){
        bigX = x;
        smallX = x;
        bigY = y;
        smallY = y;
        reposition();
    }

    public void update(int x, int y){
        int distance = (int)Math.sqrt(Math.pow(bigX - x, 2) + Math.pow(bigY - y, 2));


        if(distance > 75){
            int AP = 75;

            double th = Math.atan2(y-bigY, x - bigX);

            smallX = (int)(bigX + AP*Math.cos(th));
            smallY = (int)(bigY + AP*Math.sin(th));

        }else {
            smallX = x;
            smallY = y;
        }
        reposition();
    }

    public void show(){
        reposition();
        big.setVisible(true);
        small.setVisible(true);
    }

    public void hide(){
        bigX = 0;
        smallX = 0;
        big.setVisible(false);
        small.setVisible(false);
    }

    private void reposition(){
        big.setPosition(bigX - 75, Gdx.graphics.getHeight()-bigY - 75);
        small.setPosition(smallX-25,Gdx.graphics.getHeight()-smallY-25);
    }

    public int getDifferenceX(){
        return smallX - bigX;
    }
    public int getDifferenceY(){
        return  bigY- smallY;
    }
}
