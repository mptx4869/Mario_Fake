package entity.heros;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Character;
import entity.Load_Entity;
import manager.HeroManager;
import screen.GamePlayScreen;

public class Hero_1_SmallMario extends Character {

    public Hero_1_SmallMario(){
        this.images = new BufferedImage[]{
            Load_Entity.listImages.get(0).getSubimage(0, 0, 36, 48),
            Load_Entity.listImages.get(0).getSubimage(0 , 48, 42, 45),
            Load_Entity.listImages.get(0).getSubimage(42, 0, 36, 48),
            Load_Entity.listImages.get(0).getSubimage(42, 48, 42, 45)
        };
        speed = 0.2;
    }
    
    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        g2.drawImage(images[imageDraw], screenX, screenY,scale.width * GamePlayScreen.tileSize , scale.height * GamePlayScreen.tileSize,null);
    }
    
}
