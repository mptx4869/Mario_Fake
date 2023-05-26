package manager;



import java.io.File;


import java.util.ArrayList;
//import java.util.spi.ToolProvider;

import java.awt.image.BufferedImage;



 

import entity.Load_Entity;
import entity.Tile;


public class TileManager {
    public static ArrayList<Tile> tiles = new ArrayList<>();
    public static ArrayList<Character> characters = new ArrayList<>();
    public static ArrayList< BufferedImage> listImageTile = new ArrayList<BufferedImage>();
    public Map mapchosen;

    public TileManager(){
        getTiles(); 
    }

    
    
    

    public void getTiles(){
        String pathFolderImage = "media/entity/tiles";
        String pathFolderClass = "entity/tiles";

        File folderImage = new File(pathFolderImage);
        if(!folderImage.exists()) System.out.println("ERRO: can load Image File : " + folderImage.getAbsolutePath());

        File folderClass = new File(pathFolderClass);
        if(!folderClass.exists()) System.out.println("ERRO: can't load class File : "+folderClass.getPath());

        Load_Entity loader = new Load_Entity<Tile>();

        loader.getImage(folderImage);
        tiles = loader.getClass(folderClass,"entity.tiles.");
    }
}
