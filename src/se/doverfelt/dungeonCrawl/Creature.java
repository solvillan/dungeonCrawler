package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import it.randomtower.engine.entity.Entity;

public abstract class Creature extends Entity {

    public static final String ZOMBIE = "zombie";
	
	private CreatureAI ai;
	public CreatureAI getAI() { return ai; }
	
	public static final int tileSize = 16;
	public static final int scaleFactor = 2;
	
	private int maxHp;
	public int maxHp() { return maxHp; }
	
	private int hp;
	public int hp() { return hp; }
	
	private int attackValue;
	public int attackValue() { return attackValue; }
	
	private int defenseValue;
	public int defenseValue() { return defenseValue; }
	
	private Vector2f v2fPos = new Vector2f();
	public Vector2f getVector2f() { return v2fPos; }
	
	public Creature(float x, float y, int maxHp, int attack, int defense) {
		super(x, y);
		this.maxHp = maxHp;
		this.hp = maxHp;
		this.attackValue = attack;
		this.defenseValue = defense;
		v2fPos.x = x;
		v2fPos.y = y;
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		//super.update(gc, delta);
		v2fPos.set(x, y);
	}
	
	public void setAI(CreatureAI ai) {
		this.ai = ai;
	}
	
	public void move(float dx, float dy) {
		float cx = x + dx * 2 ;
		float cy = y + dy * 2;
		
		if (cx >= world.width || cy >= world.height) {
			return;
		} else if (cx <= 0 || cy <= 0) {
			return;
		}
		
		if (this.collide(Tile.WALL, cx, cy) == null) {
			x = cx;
			y = cy;
		}
		
	}
	
	@Override
	public void collisionResponse(Entity other) {
		ai.collide(other);
	}
	
	public void updateAI() {
		ai.update();
	}
	
	public void attack(Creature other) {
		
		int amount = Math.max(0, attackValue() - other.defenseValue());
		
		amount = (int) (Math.random() * amount) + 1;
		
		other.modifyHp(-amount);
		
		//notify(name + " dealt %1$s damage to %2$s.", Integer.toString(amount), other.name);
		
	}

	public void modifyHp(int amount) {
		
		hp += amount;
		
		if (hp < 1) {
			world.remove(this);
		}
		
	}
	
	public void notify(String message, Object ... params) {
		
		ai.onNotify(String.format(message, params));
		
	}
	
}
