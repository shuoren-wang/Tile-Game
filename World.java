package worlds;

import entity.EntityManager;
import entity.Player;
import entity.Tree;
import tile.Tile;
import tilegame.Handler;
import utils.Utils;

import java.awt.*;

/**
 * Created by shuorenwang on 2016-07-16.
 */
public class World {

    private Handler handler;
    private int width, height;
    private int playerX, playerY;  //player start postion
    private int[][] worldTiles;

    //Entities
    private EntityManager entityManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager=new EntityManager(handler,new Player(100,100,handler));
        entityManager.addEntity(new Tree(100,200, handler));
        entityManager.addEntity(new Tree(300,400, handler));

        loadWorld(path);

        entityManager.getPlayer().setX(playerX);
        entityManager.getPlayer().setY(playerY) ;
    }

    public void tick(){
        entityManager.tick();
    }


    public void render(Graphics g){
        int xStart=(int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd=(int) Math.min(width,(handler.getWidth()+ handler.getGameCamera().getxOffset())/Tile.TILE_WIDTH+1);
        int yStart=(int) Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int yEnd=(int) Math.min(height,(handler.getGameCamera().getyOffset()+ handler.getHeight())/Tile.TILE_HEIGHT+1);


        for(int y=yStart; y<yEnd; y++)
            for (int x=xStart; x<xEnd; x++) {
                getTile(x,y).render(g,
                                    (int)(x*Tile.TILE_WIDTH- handler.getGameCamera().getxOffset()),
                                    (int)(y*Tile.TILE_HEIGHT- handler.getGameCamera().getyOffset()));
            }

        //Entities
        entityManager.render(g);
    }

    /**
     * if (x,y) is outside the map, return grassTile,
     * if the tile on map is null, return dirtTile,
     * otherwise, return the corresponding tile
     *
     * @param x index of tile on the x direction (column)
     * @param y index of tile on the y direction (row)
     * @return tile
     */
    public Tile getTile(int x, int y){
        //(x,y) outside the map
        if(x<0 || y<0||x>width||y>width)
            return Tile.grassTile;


        Tile t=Tile.tiles[worldTiles[x][y]];

        if(t==null)
            t=Tile.dirtTile;

        return t;
    }


    private void loadWorld(String path){
        String file= Utils.loadFileAsString(path);
        String[] tokens=file.split("\\s+");

        width=Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        playerX=Utils.parseInt(tokens[2]);
        playerY=Utils.parseInt(tokens[3]);

        worldTiles=new int[width][height];
        for (int y=0; y<height ;y++)
            for(int x=0; x<width; x++){
                worldTiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
            }

    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
