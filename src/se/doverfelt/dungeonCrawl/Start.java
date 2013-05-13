package se.doverfelt.dungeonCrawl;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.Random;

import it.randomtower.engine.ME;

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

    public static LoadScreen loadScreen;
	
	public Start(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {

        loadScreen = new LoadScreen(0, arg0);

        addState(loadScreen);
		addState(new WorldMenu(1, arg0));
		addState(new WorldOverworld(2, arg0));

        enterState(0);
		
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
			appgc.setResizable(true);
			appgc.setTargetFrameRate(random.nextInt(60));
			appgc.start();
			
			ME.keyToggleDebug = Input.KEY_1;
			
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
