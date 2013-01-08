package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.ResourceManager;
import it.randomtower.engine.World;

public class WorldOverworld extends World {

	private int xx = 100;
	private int yy = 100;
	
	public WorldOverworld(int id, GameContainer container) {
		super(id, container);
		
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		
		g.drawImage(ResourceManager.getSpriteSheet("env").getSubImage(0, 0).getScaledCopy(4), xx, yy);
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_Q)) {
			System.exit(0);
		}
		
	}
	
}
