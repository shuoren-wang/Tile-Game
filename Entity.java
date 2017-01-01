package entity;

import tilegame.Game;
import tilegame.Handler;

import java.awt.*;
import java.util.Comparator;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public abstract class Entity {

    protected Handler handler;
    protected float x;
    protected float y;
    protected int width, height;
    protected Rectangle bounds;  //collision box


    public Entity(float x, float y, int width, int height, Handler handler){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

        this.handler=handler;

        bounds=new Rectangle(0,0,width,height);

    }

    public abstract void tick();

    public abstract void render(Graphics g);


    /**
     * check collision with every entities but itself in the list
     * by comparing each entity's Collision box
     * @param xOffset
     * @param yOffset
     * @return true if there is a collision
     */
    public boolean checkEntityCollision(float xOffset, float yOffset){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(this.getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;

    }


    /**
     * make a collision box for the entity
     * @param xOffset
     * @param yOffset
     * @return collision box
     */

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x+bounds.x+xOffset),(int) (y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    //GETTERS and SETTERS

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
