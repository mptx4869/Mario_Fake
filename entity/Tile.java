package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public  class Tile extends Entity {
    public boolean conllision = true;
    
    public BufferedImage getImage(){
        return images[0];
    }
    @Override
    public void action() {
        System.out.println("Tile class");
    }

}
