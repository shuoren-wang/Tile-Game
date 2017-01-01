package tile;

import gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Created by shuorenwang on 2016-07-16.
 */
public class WallTile extends Tile {
    public WallTile(int id) {
        super(Assets.wall, id);
    }


    /**
     * @return true, if solid and cannot walk through;
     */
    @Override
    public boolean isSolid(){
        return true;
    }
}
