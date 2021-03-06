package se.doverfelt.dungeonCrawl;

import java.util.Arrays;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import it.randomtower.engine.World;
import it.randomtower.engine.Camera;

public class WorldOverworld extends World {
	
	private Map map;
	
	public Player player;
	private PlayerName pname;
	
	public static Zombie zombie;
	
	private Hud hud;
	
	private int health = 100;
	
	private ChatWindow chat;
	
	public boolean isInitialized = false;
	
	public WorldOverworld(int id, GameContainer container) {
		super(id, container);
	}
	
	@Override
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
		if (!isInitialized) {
			map = new Map("map1");
			chat = new ChatWindow(gc, false, gc.getGraphics());
			hud = new Hud();
			player = new Player(100, 100);
			map.loadEntityFromMap(Arrays.asList("ground"), this);
			map.loadEntityFromMap(Arrays.asList("tree"), this);
            map.loadEntityFromMap(Arrays.asList("playerspawn"), this);
			//add(player);
            if (player != null) {
                zombie = new Zombie(425, 425, this);
                add(zombie);
                pname = new PlayerName(10, 10, player, gc.getGraphics());
                add(pname);
                add(player);
			    this.setCamera(new Camera(player, gc.getWidth(), gc.getHeight()));
            } else {
                try {
                    throw new Throwable("No player in map!");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                sbg.enterState(1);
            }
			isInitialized = true;
			Log.debug("Initialized Overworld");
		}
		
		
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if (gc.hasFocus()) {
			
			g.setFont(FontManager.getDefault());

            //g.drawImage(ResourceManager.getSpriteSheet("bg"), 0, 0, gc.getWidth(), gc.getHeight());
            g.drawImage(ResourceManager.getSpriteSheet("bg"), 0, 0, gc.getWidth(), gc.getHeight(), 0, 0, ResourceManager.getSpriteSheet("bg").getWidth(), ResourceManager.getSpriteSheet("bg").getHeight());

			super.render(gc, sbg, g);
			g.setColor(Color.white);
			g.drawString("FPS: " + gc.getFPS(), 10, 40);
			chat.render();
			hud.drawVersion(g);
			hud.drawHealth(g, player.hp() / player.maxHp() * 100);
			//hud.drawPlayerName(g, player);
		}
		
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if (gc.hasFocus() && isInitialized) {
			Input input = gc.getInput();
			if (!chat.hasFocus()) {
				super.update(gc, sbg, delta);
				zombie.updateAI();
			} else {
				if (input.isKeyPressed(Input.KEY_UP)) {
					chat.setMessage(chat.getNextHistory());
				}
				if (input.isKeyPressed(Input.KEY_DOWN)) {
					chat.setMessage(chat.getPrevHistory());
				}
			}
			if (input.isKeyPressed(Input.KEY_ESCAPE)) {
				sbg.enterState(1);
			}
			if (input.isKeyPressed(Input.KEY_LSHIFT)) {
				zombie.modifyHp(1);
			}
			if (input.isKeyPressed(Input.KEY_LCONTROL)) {
				zombie.modifyHp(-1);
			}
			if (input.isKeyPressed(Input.KEY_HOME)) {
				//ServerHost code 
			}
			if (input.isKeyPressed(Input.KEY_T) && !chat.hasFocus()) {
				chat.setVisible(true);
				chat.setFocus(true);
			}
			if (input.isKeyPressed(Input.KEY_ENTER) && chat.hasFocus()) {
				chat.sendMessage();
				chat.setVisible(false);
				chat.setFocus(false);
			}
			if (input.isKeyPressed(Input.KEY_ESCAPE) && chat.hasFocus()) {
				chat.setVisible(false);
				chat.setFocus(false);
			}
		}
		
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
