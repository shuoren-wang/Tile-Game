package tilegame;

import gfx.GameCamera;
import input.KeyManager;
import states.GameState;
import worlds.World;

/**
 * Created by shuorenwang on 2016-07-17.
 */
public class Handler {
    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;

    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    /**
     * @return width of the game screen width
     */
    public int getWidth(){
        return game.getWidth();
    }

    /**
     * @return height of the game screen height
     */
    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
