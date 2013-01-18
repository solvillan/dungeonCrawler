package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.Graphics;

public class Hud {
	
	private String version = "Dungeon Crawl 0.0.1";
	
	public Hud() {
	}
	
	public void drawVersion(Graphics g) {
		
		g.drawString(version, 5, 5);
		
	}
	
	public void drawHealth(Graphics g, int health) {
		
		g.fillRect(5, 20, health * 2, 10);
		
	}
	
}
