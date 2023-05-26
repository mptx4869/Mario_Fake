package manager;

import java.util.ArrayList;

import entity.Load_Entity;
import java.io.File;

public class EnemyManager {
    public ArrayList<Character> enemies = new ArrayList<>();
    public EnemyManager(){
        getEnemies();
    }
    public void getEnemies(){
        String pathFolderImage = "media/entity/enemies";
        String pathFolderClass = "entity/enemies";

        File folderImage = new File(pathFolderImage);
        if(!folderImage.exists()) System.out.println("ERRO: can load Image File : " + folderImage.getAbsolutePath());

        File folderClass = new File(pathFolderClass);
        if(!folderClass.exists()) System.out.println("ERRO: can't load class File : "+folderClass.getPath());

        Load_Entity loader = new Load_Entity<Character>();
        
        loader.getImage(folderImage);
        enemies = loader.getClass(folderClass,"entity.enemies.");
    }
}
