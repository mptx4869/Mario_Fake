package entity;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import java.awt.Graphics2D;



public abstract class Entity {
    public BufferedImage[] images;
    protected Dimension dimension ;
    public static void setScale(int scale){

    }
    public BufferedImage getimage(int index){
        return images[index];
    }
    public abstract void action();
    public abstract void draw( Graphics2D g2,int screenX,int screenY);
    //public abstract void abilitries(Character character,CollisionDirection collisionDirection,int mapX,int mapY);
}
