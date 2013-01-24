package se.doverfelt.dungeonCrawl;

import java.io.IOException;
import java.util.Random;

import it.randomtower.engine.ME;
import it.randomtower.engine.ResourceManager;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

public class Start extends StateBasedGame {

	private boolean resourcesInitiated = false;

	public static String USERNAME;
	private static Random random = new Random();
	
	public Start(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		
		initResources();
		
		addState(new WorldMenu(1, arg0));
		addState(new WorldOverworld(2, arg0));
		
	}
	
	public static void main(String[] args) {
		if (args.length >= 1) {
			USERNAME = args[0];
		} else {
			USERNAME = "Player" + random.nextInt(1000);
		}
		
		try {
			AppGameContainer appgc = new AppGameContainer(new Start("Dungeon Crawl 0.1"));
			appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), true);
			appgc.setTargetFrameRate(60);
			appgc.start();
			
			ME.keyToggleDebug = Input.KEY_1;
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	private void initResources() throws SlickException {
		
		if (resourcesInitiated ) {
			return;
		}
		
		 try {
			   ResourceManager.loadResources("data/resources.xml");
			  } catch (IOException e) {
			   Log.error("Failed to load resource file 'data/resources.xml': " + e.getMessage());
			   throw new SlickException("Resource loading failed!");
			  }
			 
		resourcesInitiated = true;
		
	}
	
	
}
