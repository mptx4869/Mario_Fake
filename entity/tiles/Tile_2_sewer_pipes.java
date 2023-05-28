package entity.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Load_Entity;
import entity.Tile;
import manager.TileManager;
import screen.GamePlayScreen;



public class Tile_2_sewer_pipes extends Tile {
    public Tile_2_sewer_pipes() {
        this.images = new BufferedImage[]{Load_Entity.listImages.get(2)};
    }

    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        g2.drawImage(images[0],screenX,screenY,GamePlayScreen.tileSize,GamePlayScreen.tileSize,null);
    }
//     @Override
//     public void abilitries(Character character, CollisionDirection collisionDirection,int mapX,int mapY) {
//         switch (collisionDirection){
//             case LEFT : 
//                 for(int i=0;i<character.speed*(GamePanel.tileSize/character.speed);i++)
//                     character.rightMove();
//                 break;
//             case RIGHT:
//                 for(int i=0;i<character.speed*(GamePanel.tileSize/character.speed);i++) 
//                     character.leftMove();
//                 break;
//             case BOTTOM:
//                 character.jumping = character.jumpHeight*2;

//         }
        
//     }
}