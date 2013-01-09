package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.ResourceManager;

public class Player extends Creature {
	
	public Player(float x, float y) {
		super(x, y);
		setGraphic(ResourceManager.getSpriteSheet("char").getSubImage(1, 1).getScaledCopy(4));
		
		addType(PLAYER);
		
		setAI(new PlayerAI(this));
		
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException{
		super.update(gc, delta);
		
		Input input = gc.getInput();
		
		if (input.isKeyDown(Input.KEY_W)) {
			move(0, -1);
		}
		if (input.isKeyDown(Input.KEY_S)) {
			move(0, 1);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			move(-1, 0);
		}
		if (input.isKeyDown(Input.KEY_D)) {
			move(1, 0);
		}
		
	}

}
