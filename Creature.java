package entity;

import tile.Tile;
import tilegame.Handler;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public abstract class Creature extends Entity{

    public static final int DEFAULT_HEALTH=10;
    public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_CREATURE_WIDTH=64,
                            DEFAULT_CREATURE_HEIGHT=64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(float x, float y, int width, int height, Handler handler) {
        super(x, y,width,height,handler);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        xMove =0;
        yMove =0;
    }


    public void move(){
        if(!checkEntityCollision(xMove,0f))
            moveX();
        if(!checkEntityCollision(0f,yMove))
            moveY();
    }

    public void moveX(){
        int tileX;

        if(xMove>0){ //moving right
            tileX=(int)(x+xMove+bounds.x+bounds.width)/ Tile.TILE_WIDTH;

            if(checkHorizontalCollision(tileX)){
                x+=xMove;
            }else{
                x=tileX*Tile.TILE_WIDTH-(bounds.width+bounds.x)-1;
            }
        }else if (xMove<0){//moving left
            tileX=(int)(x+xMove+bounds.x)/ Tile.TILE_WIDTH;

            if(checkHorizontalCollision(tileX)){
                x+=xMove;
            }else{
                x=(tileX+1)*Tile.TILE_WIDTH-bounds.x;
            }
        }
    }

    public void moveY(){
        int tileY;

        if(yMove>0){ //moving down
            tileY=(int)(y+yMove+bounds.y+bounds.height)/ Tile.TILE_HEIGHT;

            if(checkVerticalCollision(tileY))  {
                y+=yMove;
            }else{
                y=tileY*Tile.TILE_HEIGHT-(bounds.height+bounds.y)-1;

            }

        }else if (yMove<0){//moving up
            tileY=(int)(y+yMove+bounds.y)/ Tile.TILE_HEIGHT;

                if(checkVerticalCollision(tileY) ){
                    y+=yMove;
                }else{
                    y=(tileY+1)*Tile.TILE_HEIGHT-bounds.y;
                }
        }
    }



    /**
     * check if there is collision on the upper left(or right) and lower left(or right) corner
     * @param tileX index of tile on x direction
     * @return true if there is collision on the left side
     */
    private boolean checkHorizontalCollision(int tileX){
        return !collisionWithTile(tileX,(int) (y+bounds.y)/Tile.TILE_HEIGHT) &&    //check upper corner
                !collisionWithTile(tileX,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT); //check lower corner
    }


    /**
     * check if there is collision on the upper left and lower left corner
     * @param tileY index of tile on x direction
     * @return true if there is collision on the left side
     */
    private boolean checkVerticalCollision(int tileY){
        return !collisionWithTile((int) (x+bounds.x)/Tile.TILE_WIDTH,tileY) &&   //check left conner
                !collisionWithTile((int) (x+bounds.x+bounds.width)/Tile.TILE_WIDTH,tileY) ; //check right conner
    }


    /**
     * if the tile on (x,y) is solid, => colision
     * @param x index of tile on the x direction (column)
     * @param y index of tile on the y direction (row)
     * @return true if the tile is solid
     */
    protected boolean collisionWithTile(int x,int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }


    //GETTERS and SETTERS
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

}
