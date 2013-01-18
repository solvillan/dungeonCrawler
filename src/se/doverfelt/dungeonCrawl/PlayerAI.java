package se.doverfelt.dungeonCrawl;

import it.randomtower.engine.World;
import it.randomtower.engine.entity.Entity;

public class PlayerAI extends CreatureAI {

	private World world;
	
	public PlayerAI(Creature creature, WorldOverworld world) {
		super(creature);
		this.world = world;
	}
	
	@Override
	public void collide(Entity other) {
		
	
		
	}

}
