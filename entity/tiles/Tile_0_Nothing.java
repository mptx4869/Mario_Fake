package entity.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Load_Entity;
import entity.Tile;
import manager.TileManager;
import screen.GamePlayScreen;

public class Tile_0_Nothing extends Tile {
    public Tile_0_Nothing(){
        images = new BufferedImage[] {Load_Entity.listImages.get(0)};
    }
    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        g2.drawImage(getimage(0), screenX  , screenY,GamePlayScreen.tileSize,GamePlayScreen.tileSize,null);
    }
    @Override
    public void action() {
        //don't have action
    }
}
