package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.Image;

import it.randomtower.engine.entity.Entity;

public class Tile extends Entity{
	
	public static String WALL = "wall";
	
	public Tile(float x, float y, Image image) {
		super(x, y, image);
		setHitBox(0, 0, image.getWidth(), image.getHeight());
		addType(WALL);
	}

}
