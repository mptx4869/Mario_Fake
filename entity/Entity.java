package entity;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import screen.GamePlayScreen;

import java.awt.Graphics2D;



public abstract class Entity {
    public BufferedImage[] images;
    protected Dimension scale  = new Dimension(1, 1);
    public int imageDraw;
    public static void setScale(int scale){

    }
    public BufferedImage getimage(int index){
        return images[index];
    }
    public abstract void action();
    public void draw( Graphics2D g2,int screenX,int screenY){
        g2.drawImage(images[imageDraw],screenX,screenY,scale.width* GamePlayScreen.tileSize , scale.height*GamePlayScreen.tileSize,null);
    }
}
