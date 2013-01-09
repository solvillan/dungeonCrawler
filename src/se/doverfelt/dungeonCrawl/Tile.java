package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.Image;

import it.randomtower.engine.entity.Entity;

public class Tile extends Entity{

	public Tile(float x, float y, Image image) {
		super(x, y, image);
		addType("obstacle");
		collidable = true;
	}

}
