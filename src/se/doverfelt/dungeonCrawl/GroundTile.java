package se.doverfelt.dungeonCrawl;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import it.randomtower.engine.entity.Entity;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GroundTile extends Entity{

    public static String WALL = "wall";

    public GroundTile(float x, float y, Image image) {
        super(x, y, image);
        setHitBox(0, 0, image.getWidth(), image.getHeight());
        addType(SOLID);
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        if (this.x < (((WorldOverworld)world).player.x + (gc.getWidth() / 2)) && this.x + this.currentImage.getWidth() > (((WorldOverworld)world).player.x - (gc.getWidth() / 2)) && this.y < (((WorldOverworld)world).player.y + (gc.getHeight() / 2))  && this.y + this.currentImage.getWidth() > (((WorldOverworld)world).player.y - (gc.getHeight() / 2))) {
            this.getCurrentImage().draw(this.x, this.y);
        }

    }

}
