package se.doverfelt.dungeonCrawl;

import it.randomtower.engine.entity.Entity;

public abstract class CreatureAI {
	
	protected Creature creature;
	
	public CreatureAI(Creature creature) {
		this.creature = creature;
		this.creature.setAI(this);
	}
	
	public void collide(Entity other) {
		
	}
	
	public void update() {
		
	}

	public void onNotify(String format) {
		
		
	}
	
}
