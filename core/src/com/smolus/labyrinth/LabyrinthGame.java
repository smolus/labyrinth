package com.smolus.labyrinth;

import com.badlogic.gdx.Game;
import com.smolus.labyrinth.screens.SplashScreen;

public class LabyrinthGame extends Game{

	public static final int WORLD_WIDTH = 10;
	public static final int WORLD_HEIGHT = 10;

	private boolean paused = false;

	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	/*
	*
	* Getters and setters
	*
	* */

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

}
