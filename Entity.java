package entity;

import tilegame.Game;
import tilegame.Handler;

import java.awt.*;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public abstract class Entity {

    protected Handler handler;
    protected float x;
    protected float y;
    protected int width, height;
    protected Rectangle bounds;


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
