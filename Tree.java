package entity;

import gfx.Assets;
import tile.Tile;
import tilegame.Handler;

import java.awt.*;

/**
 * Created by shuorenwang on 2016-07-17.
 */
public class Tree extends StaticEntity {


    public Tree(float x, float y, Handler handler) {
        super(x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,(int)(x-handler.getGameCamera().getxOffset()),
                                (int)(y-handler.getGame().getGameCamera().getyOffset()),
                                width,height,null);

    }
}
