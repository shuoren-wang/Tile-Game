package gfx;

import entity.Entity;
import tile.Tile;
import tilegame.Game;
import tilegame.Handler;

/**
 * Created by shuorenwang on 2016-07-16.
 */
public class GameCamera {
    Handler handler;
    private float xOffset, yOffset;


    public GameCamera(Handler handler,float xOffset, float yOffset){
        this.handler=handler;

        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }


    /**
     * if there is blank space on the left, right, top or bottom, fix it
     */

    public void checkBlankSpace(){
        if(xOffset<0){  // blank space on left
            xOffset=0;
        }
        else  if(xOffset>handler.getWorld().getWidth()* Tile.TILE_WIDTH - handler.getWidth()){ // blank space on right
            xOffset=handler.getWorld().getWidth()* Tile.TILE_WIDTH - handler.getWidth();
        }

        if(yOffset<0){  //blank space on top
            yOffset=0;
        }else if(yOffset>handler.getWorld().getWidth()* Tile.TILE_HEIGHT - handler.getHeight()){//blank space below
            yOffset=handler.getWorld().getWidth()* Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e){
        xOffset=e.getX()-handler.getWidth()/2+e.getWidth()/2;
        yOffset=e.getY()-handler.getHeight()/2+e.getHeight()/2;

        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
    }


    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        checkBlankSpace();
    }
    
    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        checkBlankSpace();
    }
}
