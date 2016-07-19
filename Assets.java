package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public class Assets {

    public static final int width=108, height=108;
    public static BufferedImage dirt, grass, wall , tree,stone;
    public static BufferedImage[] player_left,player_right;


    public static void init(){
        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("res/textures/tile.png"));

        player_left=new BufferedImage[2];
        player_right=new BufferedImage[2];

        player_right[0]=sheet.crop(0,height,width,height);
        player_right[1]=sheet.crop(width,height,width,height);
        player_left[0]=sheet.crop(2*width,height,width,height);
        player_left[1]=sheet.crop(3*width,height,width,height);

        dirt=sheet.crop(0,0,width,height);
        tree=sheet.crop(width,0, width,height);
        stone=sheet.crop(2 * width,0,width,height);
        grass=sheet.crop(3 * width,0,width,height);
       // player=sheet.crop(0,height,width,height);
        wall=sheet.crop(0,2*height,width,height);
    }
}
