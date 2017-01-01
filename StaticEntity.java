package entity;

import tilegame.Handler;

/**
 * Created by shuorenwang on 2016-07-17.
 */
public abstract class
StaticEntity extends Entity {
    public StaticEntity(float x, float y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
    }


}
