package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import it.randomtower.engine.entity.Entity;

public class PlayerName extends Entity {

	private Player player;
	private int w;
	private int h;
	
	public PlayerName(float x, float y, Player player, Graphics g) {
		super(x, y);
		
		this.player = player;
		
		w = FontManager.getDefault().getWidth(Start.USERNAME);
		h = FontManager.getDefault().getHeight(Start.USERNAME);
		
		Image img = null;
		try {
			img = Image.createOffscreenImage(w, h);
			Graphics g2 = img.getGraphics();
			g2.setFont(FontManager.getDefault());
			g2.setBackground(Color.black);
			g2.clear();
			g2.setColor(Color.white);
			g2.drawString(Start.USERNAME, 0, 0);
			g2.flush();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		setGraphic(img);
		
	}
	
	@Override
	public void update(GameContainer gc, int delta) {
		
		x = (player.x +(player.width / 2)) - (w / 2);
		y = player.y - h;
		
	}
	
	
	
}
