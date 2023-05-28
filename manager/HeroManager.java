package manager;

import java.util.ArrayList;

import entity.Character;
import entity.Load_Entity;
import java.io.File;

public class HeroManager {
    public static ArrayList<Character> heros = new ArrayList<>();
    public HeroManager(){
        getHeros();
    }
    public void getHeros(){
        String pathFolderImage = "media/entity/heros";
        String pathFolderClass = "entity/heros";

        File folderImage = new File(pathFolderImage);
        if(!folderImage.exists()) System.out.println("ERRO: can load Image File : " + folderImage.getAbsolutePath());

        File folderClass = new File(pathFolderClass);
        if(!folderClass.exists()) System.out.println("ERRO: can't load class File : "+folderClass.getPath());

        Load_Entity loader = new Load_Entity<Character>();
        
        loader.getImage(folderImage);
        heros = loader.getClass(folderClass,"entity.heros.");
    }
}