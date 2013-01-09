package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.util.Log;

import it.randomtower.engine.entity.Entity;

public class PlayerAI extends CreatureAI {

	public PlayerAI(Creature creature) {
		super(creature);
	}
	
	@Override
	public void collide(Entity other) {
		
		Log.debug("Hit: " + other);
		
	}

}
