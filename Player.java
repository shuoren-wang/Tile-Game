package entity;

import gfx.Animation;
import gfx.Assets;
import tilegame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public class Player extends Creature {


    //Animations
    private Animation walkLeft;
    private Animation walkRight;

    public Player(float x, float y, Handler handler){
        super(x,y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT,handler);
        bounds.x=24;
        bounds.y=22;
        bounds.width=20;
        bounds.height=33;


        //Animations
        walkLeft=new Animation(100,Assets.player_left);
        walkRight=new Animation(100,Assets.player_right);
    }


    /**
     * move player according to the keyboard input (arrows)
     */
    private void getInput(){
        xMove =0;
        yMove =0;

        if(handler.getKeyManager().right)
            xMove +=speed;
        if(handler.getKeyManager().left)
            xMove -=speed;
        if(handler.getKeyManager().up)
            yMove -=speed;
        if(handler.getKeyManager().down)
            yMove +=speed;
    }


    @Override
    public void tick() {
        //Animations
        walkRight.tick();
        walkLeft.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width,height,null);

//        g.setColor(Color.red);
//        g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width,bounds.height);

    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove<0){  //move Left
            return walkLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return walkRight.getCurrentFrame();
        }

        return walkRight.getCurrentFrame();
    }


}
