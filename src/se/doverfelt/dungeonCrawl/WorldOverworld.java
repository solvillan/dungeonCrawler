package se.doverfelt.dungeonCrawl;

import java.util.Arrays;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import it.randomtower.engine.Camera;
import it.randomtower.engine.World;

public class WorldOverworld extends World {
	
	private Map map;
	
	private Player player;
	
	public WorldOverworld(int id, GameContainer container) {
		super(id, container);
		
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
		map = new Map("map1");
		
		player = new Player(10, 10);
		
		map.loadEntityFromMap(Arrays.asList("ground"), this);
		map.loadEntityFromMap(Arrays.asList("tree"), this);
		
		add(player);
		
		this.setCamera(new Camera(player, gc.getWidth(), gc.getHeight()));
		
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//map.render(g);
		
		super.render(gc, sbg, g);
		g.drawString("Dungeon Crawler 0.1", 10, 25);
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		super.update(gc, sbg, delta);
		
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			sbg.enterState(1);
		}
		
	}
	
}
