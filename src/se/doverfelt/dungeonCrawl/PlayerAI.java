package se.doverfelt.dungeonCrawl;

import it.randomtower.engine.entity.Entity;

public class PlayerAI extends CreatureAI {
	
	private Player creature;
	
	public PlayerAI(Creature creature, WorldOverworld world) {
		super(creature);
		this.creature = (Player)creature;
	}
	
	@Override
	public void collide(Entity other) {
//		if (other.isType(Entity.PLAYER)) {
//			creature.collidingCreature = other;
//			creature.isColliding = true;
//		}
	}

}
