package states;

import entity.Player;
import entity.Tree;
import tile.Tile;
import tilegame.Game;
import tilegame.Handler;
import worlds.World;

import java.awt.*;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public class GameState extends State {

    private World world;

    public GameState(Handler handler){
        super(handler);
        world=new World(handler,"res/worlds/world1.txt");
        handler.setWorld(world);


    }


    @Override
    public void tick() {
        world.tick();

    }

    @Override
    public void render(Graphics g) {

        world.render(g);

    }
}
