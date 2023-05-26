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
        
    }
    @Override
    public void draw(Graphics2D g2, int screenX,int screenY) {
        
    }

}
