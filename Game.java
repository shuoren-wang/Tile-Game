package tilegame;


import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public class Game implements Runnable{

    private Display display;
    private int width, height;
    private String title;

    private Thread thread;
    private boolean running=false;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;


    public Game(String  title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;

        keyManager=new KeyManager();
    }

    private void init(){

        display=new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler=new Handler(this);
        gameCamera=new GameCamera(handler,0,0);


        gameState=new GameState(handler);
        menuState=new MenuState(handler);

        State.setState(gameState);

    }


    private void tick(){
        keyManager.tick();

        if(State.getState()!=null)
            State.getState().tick();

    }

    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g=bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0,width,height);

        //Draw Here!

        if(State.getState()!=null)
            State.getState().render(g);

        //End Drawing

        bs.show();
        g.dispose();

    }

    @Override
    public void run() {
        init();

        int fps=60;
        double timePerTick=1000000000/fps;
        double delta=0;
        long now;
        long lastTime=System.nanoTime();


        while (running){
            now=System.nanoTime();
            delta+=(now - lastTime)/timePerTick;
            lastTime=now;

            if(delta>=1){
                tick();
                render();
                delta=0;
            }
        }

        stop();
    }

    public synchronized void start(){
        if(running)
            return;
        running=true;

        thread=new Thread(this);    //run this class on thread
        thread.start();          //->run()
    }


    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try{
            thread.join(); //close thread
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
