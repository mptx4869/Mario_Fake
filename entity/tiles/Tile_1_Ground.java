package entity.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Load_Entity;
import entity.Tile;
import manager.TileManager;
import screen.GamePlayScreen;

public class Tile_1_Ground extends Tile {
    public Tile_1_Ground() {
        this.images = new BufferedImage[]{Load_Entity.listImages.get(1)};

    }
    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        System.out.println("//////");
        g2.drawImage(getimage(0),screenX,screenY,GamePlayScreen.tileSize,GamePlayScreen.tileSize,null);
    }
}
