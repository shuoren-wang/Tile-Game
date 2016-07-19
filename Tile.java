package tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by shuorenwang on 2016-07-16.
 */
public abstract class Tile {
    public static final int TILE_WIDTH=62, TILE_HEIGHT=62;

    public static Tile[] tiles=new Tile[256];
    public static Tile grassTile= new GrassTile(0);
    public static Tile dirtTile=new DirtTile(1);
    public static Tile rockTile=new WallTile(2);


    //CLASS
    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;

        tiles[id]=this;
    }


    public void tick(){}

    public void render(Graphics g,int x, int y){
        g.drawImage(texture,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }

    /**
     *
     * @return false, if  walk through;
     */
    public boolean isSolid(){
        return false;
    }

    //GETTER and SETTER
    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public int getId() {
        return id;
    }

}
