package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.World;

public class WorldMenu extends World {

	public WorldMenu(int id, GameContainer container) {
		super(id, container);
		
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		super.render(gc, sbg, g);
		
		
		
		g.drawString("Dungeon Crawler 0.1", 10, 25);
		g.drawString("Menu!", gc.getWidth() / 2, gc.getHeight() / 2);
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		super.update(gc, sbg, delta);
		
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_SPACE)) {
			sbg.enterState(2);
		}
		if (input.isKeyPressed(Input.KEY_Q)) {
			System.exit(0);
		}
		
	}

}
