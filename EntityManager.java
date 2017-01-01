package entity;

import tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by shuorenwang on 2016-07-17.
 */
public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter;

    public EntityManager(Handler handler,Player player){
        this.handler=handler;
        this.player=player;
        entities=new ArrayList<Entity>();
        entities.add(player);

        renderSorter=new Comparator<Entity>() {
            /**
             * if the bottom of e1 is higher then the bottom of e2, render e1 first
             * @param e1
             * @param e2
             * @return e1 render before e2 => -1
             *         e1 render after e2 => 1
             */
            @Override
            public int compare(Entity e1, Entity e2) {
                if ((e1.getY()+e1.height) < (e2.getY()+e2.height))
                        return -1;
                return 1;
            }
        };

    }


    /**
     * - run tick() for all entities
     * - sort the entities array according to their bottom position
     */
    public void tick(){
        for (int i=0; i<entities.size();i++){
            Entity e=entities.get(i);
            e.tick();
        }

        entities.sort(renderSorter);
    }

    public void render(Graphics g){
        for(Entity e:entities){
            e.render(g);
        }
    }


    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTERS and SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


}
