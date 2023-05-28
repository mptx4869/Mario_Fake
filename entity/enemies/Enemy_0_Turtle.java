package entity.enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Character;
import entity.Load_Entity;
import screen.GamePlayScreen;

public class Enemy_0_Turtle extends Character {
    public Enemy_0_Turtle(){
        this.images = new BufferedImage[]{
            Load_Entity.listImages.get(0).getSubimage(0, 0, 48, 64),
            Load_Entity.listImages.get(0).getSubimage(48,0,48,64)
        };
        speed = GamePlayScreen.tileSize/5;
    }
    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        
        
    }
    
}
