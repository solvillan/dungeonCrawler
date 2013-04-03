package se.doverfelt.dungeonCrawl;

import it.randomtower.engine.tween.*;

public class ZombieAI extends CreatureAI {

	private Zombie creature;
	private boolean isMoving;
	private double seed = Math.random();
	private int direction;
	private int timer = 0;
	private WorldOverworld world;
	private boolean isColliding = false;
	public boolean hasTarget = false;
	
	public ZombieAI(Zombie creature, WorldOverworld world) {
		super(creature);
		this.creature = creature;
		this.world = world;
	}
	
	@Override
	public void update() {
		
		if (creature.x < world.width && creature.x > 0 && creature.y < world.height && creature.y > 0) {
			
			float distance = creature.getVector2f().distance(world.getPlayer().getVector2f());
			//Log.debug("Distance: " + goalPos);
			
			double random = Math.random();
			if (random < 0.5 && !isMoving && !isColliding) {
				isMoving = true;
				seed = Math.random() + 0.05;
				
				if (!(distance < 250)) {
					if (seed < 0.2) {
						creature.move((float) (Math.random()), 0f);
						direction = 0;
					} else if (seed > 0.1 && seed < 0.4) {
						creature.move(0f, (float) (Math.random()));
						direction = 1;
					} else if (seed > 0.3 && seed < 0.6) {
						creature.move(-((float) (Math.random())), 0f);
						direction = 2;
					} else if (seed > 0.5 && seed < 0.8) {
						creature.move(0f, -((float) (Math.random())));
						direction = 3;
					} else {
					}
				} else {
					
					creature.tweener = new Tweener();
					creature.tweener.add(new Tween(new LinearMotion(creature.x, creature.y, world.getPlayer().x, world.getPlayer().y, 50, Ease.QUAD_IN), false));
					creature.tweener.start();
					hasTarget = true;
					
				}
			} else if (random >= 0.5 && !isMoving && !isColliding) {

				isMoving = false;
				direction = 5;

			} else if (isMoving && timer < (Math.random() * 1000) && !isColliding) {
				if (direction == 0) {
					creature.move((float) (Math.random()), 0f);
					timer++;
				} else if (direction == 1) {
					creature.move(0f, (float) (Math.random()));
					timer++;
				} else if (direction == 2) {
					creature.move(-((float) (Math.random())), 0f);
					timer++;
				} else if (direction == 3) {
					creature.move(0f, -((float) (Math.random())));
					timer++;
				} else if (direction == 5) {
					timer++;
				}
			} else {
				timer = 0;
				isMoving = false;
			}
		}
		
	}

}
