package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by shuorenwang on 2016-07-15.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }

    public BufferedImage crop(int x, int y,int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
