package entity.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Tile;

public class Tile_1_Ground extends Tile {
    public Tile_1_Ground() {
        //this.images = new BufferedImage[]{TileManager.listImageTile.get(1)};

    }
    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        //g2.drawImage(images[0],screenX,screenY,GamePanel.tileSize*Tile.scale,GamePanel.tileSize*Tile.scale,null);
    }
}
