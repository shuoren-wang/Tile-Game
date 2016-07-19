package states;

import tilegame.Game;
import tilegame.Handler;

import java.awt.*;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public abstract class State {


    //Following code can be put in class StateManager
    // START

    private static  State currentState=null;

    public static void setState(State state){
        currentState=state;
    }

    public static State getState(){
        return currentState;
    }

    //END

    //CLASS

    protected Handler handler;

    public State(Handler handler){
        this.handler=handler;
    }

    public abstract void tick();

    public abstract void render (Graphics g);

}
