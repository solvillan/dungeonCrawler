package se.doverfelt.dungeonCrawl;

import it.randomtower.engine.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.util.Log;

import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Rickard
 * Date: 3/18/13
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoadScreen extends World {
    private boolean resourcesInitiated = false;

    private int timer = 0;

    public LoadScreen(int id, GameContainer gc) {
        super(id, gc);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //initResources(gameContainer, stateBasedGame);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (!resourcesInitiated) {
            initResources(gameContainer, stateBasedGame);
        } else {

            if (timer < 1000) {
                timer += i;
            } else {
                stateBasedGame.enterState(1);
            }

        }

    }

    private void initResources(GameContainer gc, StateBasedGame sbg) throws SlickException {

        if (resourcesInitiated ) {
            return;
        }

        try {
            ResourceManager.setGraphics(gc.getGraphics());
            ResourceManager.setStateBasedGame(sbg);
            ResourceManager.loadResources("data/resources.xml");
            FontManager.loadFonts();
        } catch (IOException e) {
            Log.error("Failed to load resource file 'data/resources.xml': \n" + e.getMessage());
            throw new SlickException("Resource loading failed!");
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        resourcesInitiated = true;

    }
}
